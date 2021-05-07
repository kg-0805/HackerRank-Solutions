import java.io.*;
import java.util.*;

public class Solution {
  private static InputReader in;
  private static PrintWriter out;

  public static void main(String[] args) throws IOException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out, true);

    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    int[] dp = new int[n];
    for (int i = 1; i < n; i++) {
      if (arr[i] == 1) dp[i] = 1 << 29;
      dp[i] = 1 << 29;
      if (i >= 1 && arr[i-1] == 0) dp[i] = Math.min(dp[i], dp[i-1]+1);
      if (i >= 2 && arr[i-2] == 0) dp[i] = Math.min(dp[i], dp[i-2]+1);
    }
    out.println(dp[n-1]);
    
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
