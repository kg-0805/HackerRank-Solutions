import socket
from threading import Thread

## Write your code here
## This function is called everytime a new connection is accepted by the server

## Use this function to write data to socket
## write_string_to_socket(connection, message) where connection is the socket object and message is string

## Use this function to read data from socket
## def read_string_from_socket(connection) where connection is the socket object

def write_string_to_socket(connection, message):
    connection.send(message)
    
def read_string_from_socket(connection):
    while True:
        data = connection.recv(1024)
        if data: break
    return data

def process_client_connection(connection):
    while True:
        # read message 
        message = read_string_from_socket(connection)

        print "Message received = ", message
        sys.stdout.flush()

        # Your logic goes here
        # write message back to clinet
        write_string_to_socket(connection, message)

        if message == "END":
            break