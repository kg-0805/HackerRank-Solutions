import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        try (InputReader in = new InputReader(System.in); PrintWriter out = new PrintWriter(System.out, true)) {
            int n = in.nextInt();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++)
                al.add(in.nextInt());
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                String cmd = in.nextLine();
                if (cmd.equals("Insert")) {
                    int x = in.nextInt(), y = in.nextInt();
                    al.add(x, y);
                } else if (cmd.equals("Delete")) {
                    int x = in.nextInt();
                    al.remove(x);
                }
            }
            out.print(al.get(0));
            for (int i = 1; i < al.size(); i++)
                out.print(" " + al.get(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class InputReader implements AutoCloseable {

    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    public String next() throws Exception {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    public Integer nextInt(int radix) {
        try {
            return Integer.parseInt(next(), radix);
        } catch (Exception e) {
            return null;
        }
    }

    public Integer nextInt() {
        return nextInt(10);
    }

    public Double nextDouble() {
        try {
            return Double.parseDouble(next());
        } catch (Exception e) {
            return null;
        }
    }

    public BigInteger nextBigInteger(int radix) {
        try {
            return new BigInteger(next(), radix);
        } catch (Exception e) {
            return null;
        }
    }

    public BigInteger nextBigInteger() {
        return nextBigInteger(10);
    }

    public Long nextLong(int radix) {
        try {
            return Long.parseLong(next(), radix);
        } catch (Exception e) {
            return null;
        }
    }

    public Long nextLong() {
        return nextLong(10);
    }

    public String nextToken() {
        try {
            return next();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }

}
