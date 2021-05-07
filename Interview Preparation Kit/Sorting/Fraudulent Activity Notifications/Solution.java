import java.io.*;
import java.util.*;


public class Solution {
    private BufferedReader in;
    private StringTokenizer line;
    private PrintWriter out;
    private boolean isDebug;

    public Solution(boolean isDebug) {
        this.isDebug = isDebug;
    }

    private static final long mm = 1000000007;

    private long mult(long a, long b) {
        return a * b % mm;
    }

    public void solve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        int[] a = nextIntArray(n);
        out.println(solve0(a, d));
    }

    public int solve0(int[] a, int d) throws IOException {
        int n = a.length;
        Comparator<Pii> cmp = new Comparator<Pii>() {
            @Override
            public int compare(Pii o1, Pii o2) {
                int c = o1.key - o2.key;
                if (c != 0) return c;
                return o1.value - o2.value;
            }
        };
        TreeSet<Pii> begin = new TreeSet<>(cmp);
        TreeSet<Pii> end = new TreeSet<>(cmp);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];

            if (i >= d) {
                if (d % 2 == 0) {
                    if (x >= end.first().key + begin.last().key) {
                        res++;
                    }
                } else {
                    if (x >= end.first().key * 2) {
                        res++;
                    }
                }
                begin.remove(new Pii(a[i - d], i - d));
                end.remove(new Pii(a[i - d], i - d));
            }

            if (end.size() > 0) {
                begin.add(end.pollFirst());
            }
            if (end.size() > 0) {
                begin.add(end.pollFirst());
            }
            begin.add(new Pii(x, i));
            while (begin.size() > end.size()) {
                end.add(begin.pollLast());
            }
        }
        return res;
    }

//    public int solve1(int[] a, int d) throws IOException {
//        int n = a.length;
//        int res = 0;
//        int[] b = new int[d];
//        for (int i = d; i < n; i++) {
//            System.arraycopy(a, i - d, b, 0, d);
//            Arrays.sort(b);
//            if ()
//        }
//        return res;
//    }

    public static void main(String[] args) throws IOException {
        new Solution(args.length > 0 && "DEBUG_MODE".equals(args[0])).run(args);
    }

    public void run(String[] args) throws IOException {
        if (isDebug) {
            in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        out = new PrintWriter(System.out);
//        out = new PrintWriter("output.txt");

//        int t = nextInt();
        int t = 1;
//        int t = isDebug ? nextInt() : 1;
        for (int i = 0; i < t; i++) {
//            out.print("Case #" + (i + 1) + ": ");
            solve();
        }

        in.close();
        out.flush();
        out.close();
    }

    private int[] nextIntArray(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private long[] nextLongArray(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while (line == null || !line.hasMoreTokens()) {
            line = new StringTokenizer(in.readLine());
        }
        return line.nextToken();
    }

    private static class Pll {
        private long key;
        private long value;

        public Pll(long key, long value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pll pll = (Pll) o;

            if (key != pll.key) return false;
            return value == pll.value;

        }

        @Override
        public int hashCode() {
            int result = (int) (key ^ (key >>> 32));
            result = 31 * result + (int) (value ^ (value >>> 32));
            return result;
        }
    }

    private static class Pii {
        private int key;
        private int value;

        public Pii(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pii pii = (Pii) o;

            if (key != pii.key) return false;
            return value == pii.value;

        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "Pii{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            return !(value != null ? !value.equals(pair.value) : pair.value != null);

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
