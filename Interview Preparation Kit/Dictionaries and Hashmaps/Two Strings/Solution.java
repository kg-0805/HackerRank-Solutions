import java.io.*;
import java.util.*;

public class TwoStrings {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;

    void solve() throws IOException {
        int t = nextInt();
        outer: while (t-- > 0) {
            char[] a = nextToken().toCharArray();
            char[] b = nextToken().toCharArray();
            boolean[] has = new boolean[26];
            for (char c : a) {
                has[c - 'a'] = true;
            }
            for (char c : b) {
                if (has[c - 'a']) {
                    out.println("YES");
                    continue outer;
                }
            }
            out.println("NO");
        }
    }

    TwoStrings() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new TwoStrings();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
