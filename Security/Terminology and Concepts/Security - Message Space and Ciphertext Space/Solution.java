import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final String A = br.readLine().trim();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            sb.append(((A.charAt(i) - '0') + 1) % 10);
        }

        System.out.println(sb.toString());

        br.close();
        br = null;
    }
}
