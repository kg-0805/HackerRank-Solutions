import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final int N = Integer.parseInt(br.readLine().trim(), 10);
        final String[] data = br.readLine().trim().split(" ");
        final int[] f = new int[N];

        for (int i = 0; i < N; i++) {
            final int v = Integer.parseInt(data[i], 10);
            f[i] = v;
        }

        boolean ok = true;
        for (int i = 0; i < N; i++) {
            if (f[f[i] - 1] != i + 1) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "YES" : "NO");

        br.close();
        br = null;
    }
}
