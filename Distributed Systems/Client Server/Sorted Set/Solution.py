import struct
import socket
import sys
import threading
from collections import defaultdict


class Set(object):
    def __init__(self):
        self.vals = {}

    def __len__(self):
        return len(self.vals)

    def add(self, key, score):
        self.vals[key] = score

    def remove(self, key):
        try:
            del self.vals[key]
        except KeyError:
            pass

    def get(self, key):
        return self.vals.get(key, 0)

    def get_range(self, lower, upper):
        return [(key, value) for (key, value) in self.vals.iteritems() if lower <= value <= upper]

lock = threading.Lock()
sets = defaultdict(lambda: Set())


class Manager(threading.Thread):
    def __init__(self, conn):
        super(Manager, self).__init__()
        self.conn = conn
        self.reader = conn.makefile('rb')
        self.writer = conn.makefile('wb')

    def run(self):
        while True:
            nargs = self.read_int()
            args = [self.read_int() for i in xrange(nargs)]
            command = args[0]

            if command == 1:
                # add <set> <key> <score>
                assert len(args) == 4
                set_id, key, score = args[1], args[2], args[3]
                with lock:
                    s = sets[set_id]
                    s.add(key, score)
                self.write_int(0)
            elif command == 2:
                # remove <set> <key>
                assert len(args) == 3
                set_id, key = args[1], args[2]
                with lock:
                    if set_id in sets:
                        s = sets[set_id]
                        s.remove(key)
                self.write_int(0)
            elif command == 3:
                # size <set>
                assert len(args) == 2
                set_id = args[1]
                self.write_int(1)
                with lock:
                    if set_id in sets:
                        self.write_int(len(sets[set_id]))
                    else:
                        self.write_int(0)
            elif command == 4:
                # get_score <set> <key>
                assert len(args) == 3
                set_id, key = args[1], args[2]
                self.write_int(1)
                with lock:
                    if set_id in sets:
                        self.write_int(sets[set_id].get(key))
                    else:
                        self.write_int(0)
            elif command == 5:
                # get_range <set1> ... <setM> <0> <lower> <upper>
                lower, upper = args[-2], args[-1]
                with lock:
                    values = []
                    for arg in args[1:]:
                        if not arg: break
                        if arg in sets:
                            # sys.stdout.write('Range %s: %s\n' % (arg, sets[arg].get_range(lower, upper)))
                            # sys.stdout.flush()
                            values += sets[arg].get_range(lower, upper)
                values.sort()
                self.write_int(len(values) * 2)
                for k, v in values:
                    self.write_int(k)
                    self.write_int(v)
            elif command == 6:
                break

        self.reader.close()
        self.writer.close()
        self.conn.close()

    def read_int(self):
        data = self.reader.read(4)
        return int(struct.unpack('!i', data)[0])

    def write_int(self, val):
        data = struct.pack('!i', val)
        self.writer.write(data)
        self.writer.flush()


sys.stdout.write('Starting listening...\n')
sys.stdout.flush()
SERVER_SOCKET_PATH = "./socket"
sock = socket.socket(socket.AF_UNIX, socket.SOCK_STREAM)
sock.bind(SERVER_SOCKET_PATH)
sock.listen(10)

while True:
    conn, addr = sock.accept()
    sys.stdout.write('Connection accepted %s %s\n' % (conn, addr))
    sys.stdout.flush()
    manager = Manager(conn)
    manager.start()