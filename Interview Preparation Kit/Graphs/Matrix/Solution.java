import java.io.*;
import java.util.*;

public class Solution {

    // leave empty to read from stdin/stdout
    private static final String TASK_NAME_FOR_IO = "";

    // file names
    private static final String FILE_IN = TASK_NAME_FOR_IO + ".in";
    private static final String FILE_OUT = TASK_NAME_FOR_IO + ".out";

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) {
        new Solution().run();
    }

    int n;
    EdgeList[] e;
    boolean[] isBomb;
    long[] answer;
    long[] uAns, uMin;

    class Edge {
        int u, v;
        long cost;
        int idx;

        Edge(int u, int v, long cost, int idx) {
            this.u = u;
            this.v = v;
            this.cost = cost;
            this.idx = idx;
        }
    }

    class EdgeList {
        List<Edge> list = new ArrayList<Edge>();
    }

    private void solve() throws IOException {
        // stress();
        // timing();

        n = nextInt();
        int k = nextInt();
        e = new EdgeList[n];
        for (int i = 0; i < n; i++) {
            e[i] = new EdgeList();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt();
            int v = nextInt();
            long cost = nextLong();
            e[u].list.add(new Edge(u, v, cost, i));
            e[v].list.add(new Edge(v, u, cost, i));
        }
        isBomb = new boolean[n];
        for (int i = 0; i < k; i++) {
            int u = nextInt();
            isBomb[u] = true;
        }

        out.println(solveFast());
    }

    private void stress() {
        Random r = new Random(123456789L);

        int tcNum = 100000;
        for (int tcIdx = 0; tcIdx < tcNum; tcIdx ++) {
            n = 2 + r.nextInt(10);
            genTestCase(r);

            long ans1 = solveNaive();
            long ans2 = solveFast();
            if (ans1 != ans2) {
                throw new IllegalStateException("Mismatch: " + ans2 + " vs " + ans1);
            }

            System.out.println("OK: " + ans1 + " (" + tcIdx + " / " + tcNum + ")");
        }
    }

    private void timing() {
        Random r = new Random(123456789L);
        n = 100000;
        genTestCase(r);
        System.out.println(solveFast());
    }

    private void genTestCase(Random r) {
        e = new EdgeList[n];
        for (int i = 0; i < n; i++) {
            e[i] = new EdgeList();
        }

        LinkedList<Integer> dst = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            dst.add(i);
        }
        Collections.shuffle(dst, r);

        ArrayList<Integer> src = new ArrayList<Integer>();
        src.add(dst.removeFirst());

        int idx = 0;
        while (!dst.isEmpty()) {
            int u = src.get( r.nextInt(src.size()) );
            int v = dst.removeFirst();
            long cost = r.nextInt(100);

            e[u].list.add(new Edge(u, v, cost, idx));
            e[v].list.add(new Edge(v, u, cost, idx));
            idx++;

            src.add(v);
        }

        isBomb = new boolean[n];
        for (int i = 0; i < n; i++)
            if (r.nextInt(2) > 0) {
                isBomb[i] = true;
            }
    }

    private long solveFast() {
        answer = new long[n];
        uAns = new long[n];
        uMin = new long[n];
        Arrays.fill(uMin, Long.MAX_VALUE);
        recFast(0, -1);
        return uAns[0];
    }

    private void recFast(int u, int prevU) {
        int bombEdgeCount = 0;
        long bombEdgeSum = 0;
        long bombEdgeMaxLen = 0;
        for (Edge edge : e[u].list)
            if (edge.v != prevU) {
                recFast(edge.v, u);

                // count weight for all outgoing bombs
                if (isBomb[edge.v]) {
                    long edgeLen = Math.min(uMin[edge.v], edge.cost);
                    bombEdgeMaxLen = Math.max(bombEdgeMaxLen, edgeLen);
                    bombEdgeSum += edgeLen;
                    bombEdgeCount++;
                    uAns[u] += uAns[edge.v];
                }
            }

        if (isBomb[u]) {
            // nuke all edges that lead to a bomb
            // and this vertex stays marked as a bomb
            uAns[u] += bombEdgeSum;
            uMin[u] = Long.MAX_VALUE;
        } else {

            if (bombEdgeCount > 0) {
                // nuke all edges that lead to a bomb, except one
                // and this vertex stays marked as a bomb
                uAns[u] += bombEdgeSum - bombEdgeMaxLen;
                uMin[u] = bombEdgeMaxLen;
                isBomb[u] = true;
            }

        }
    }

    @SuppressWarnings({"ConstantConditions"})
    private long solveNaive() {
        int m2 = 1 << (n - 1);
        long result = Long.MAX_VALUE;
        for (int mask = 0; mask < m2; mask++) {
            boolean disconnected = true;
            for (int i = 0; disconnected && i < n; i++)
                if (isBomb[i]) {
                    disconnected &= recNaive(i, -1, mask);
                }
            if (disconnected) {
                long cost = 0;
                for (int i = 0; i < n; i++)
                    for (Edge edge : e[i].list)
                        if ((mask & (1 << edge.idx)) != 0) {
                            cost += edge.cost;
                        }
                result = Math.min(result, cost / 2);
            }
        }
        return result;
    }

    private boolean recNaive(int u, int prevU, int mask) {
        for (Edge edge : e[u].list)
            if (((mask & (1 << edge.idx)) == 0) && edge.v != prevU) {
                if (isBomb[edge.v]) {
                    return false;
                }
                if (!recNaive(edge.v, u, mask)) {
                    return false;
                }
            }
        return true;
    }

    public void run() {
        long timeStart = System.currentTimeMillis();

        boolean fileIO = TASK_NAME_FOR_IO.length() > 0;
        try {

            if (fileIO) {
                in = new BufferedReader(new FileReader(FILE_IN));
                out = new PrintWriter(new FileWriter(FILE_OUT));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }

            solve();

            in.close();
            out.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        long timeEnd = System.currentTimeMillis();

        if (fileIO) {
            System.out.println("Time spent: " + (timeEnd - timeStart) + " ms");
        }
    }

    private String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

}
