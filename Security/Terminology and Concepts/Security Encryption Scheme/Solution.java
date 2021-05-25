import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final int N = Integer.parseInt(br.readLine().trim(), 10);
        final StringBuilder sb = new StringBuilder();

        int res = 1;
        for (int i = 1; i <= N; i++) {
            res *= i;
        }

        System.out.println(res);

        br.close();
        br = null;
    }
}
