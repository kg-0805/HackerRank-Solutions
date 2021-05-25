import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final int N = Integer.parseInt(br.readLine().trim(), 10);
        final String[] data = br.readLine().trim().split(" ");
        final int[] inverse = new int[N];

        boolean ok = true;
        for (int i = 0; i < N; i++) {
            final int v = Integer.parseInt(data[i], 10);
            inverse[v - 1] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(inverse[i]);
        }

        br.close();
        br = null;
    }
}
