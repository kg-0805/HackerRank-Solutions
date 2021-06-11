import java.io.*;
import java.util.*;

public class Solution {
  private static InputReader in;
  private static PrintWriter out;

  public static void main(String[] args) throws IOException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out, true);

    int n = in.nextInt();
    int[] p = new int[n];
    long num = 1;
    for (int i = 0; i < n; i++) {
      num *= i+1;
      p[i] = in.nextInt();
    }
    boolean ok = true;
    for (int i = 1; i < n; i++) {
      ok &= p[i] >= p[i-1];
    }
    long[] nways = new long[1<<n];
    nways[0] = 1;
    for (int mask = 1; mask < 1 << n; mask++) {
      int max = 0;
      for (int i = 0; i < n; i++) {
        if (((mask>>i)&1) == 1) {
          max = Math.max(max, p[i]);
        }
      }
      for (int i = 0; i < n; i++) {
        if (((mask>>i)&1) == 1) {
          if (p[i] == max) {
            nways[mask] += nways[mask^(1<<i)];
          }
        }
      }
    }
    out.printf("%.6f\n", ok?0.0:num/(double)nways[(1<<n)-1]);
    
    out.close();
    System.exit(0);
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }


}
