import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final int N = Integer.parseInt(br.readLine().trim(), 10);

        final List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for (int i = 0; i < N; i++) {
            final String[] data = br.readLine().trim().split(" ");
            final int D = Integer.parseInt(data[0], 10);
            final List<Integer> a = new ArrayList<Integer>();
            for (int j = 1; j <= D; j++) {
                final int v = Integer.parseInt(data[j], 10);
                a.add(v);
            }
            arr.add(a);
        }

        final StringBuilder sb = new StringBuilder();
        final int Q = Integer.parseInt(br.readLine().trim(), 10);
        for (int i = 0; i < Q; i++) {
            final String[] query = br.readLine().trim().split(" ");
            final int r = Integer.parseInt(query[0], 10);
            final int c = Integer.parseInt(query[1], 10);
            if (r > arr.size()) {
                sb.append("ERROR!\n");
            } else {
                final List<Integer> row = arr.get(r - 1);
                if (c > row.size()) {
                    sb.append("ERROR!\n");
                } else {
                    sb.append(row.get(c - 1)).append('\n');
                }
            }
        }

        System.out.print(sb.toString());

        br.close();
        br = null;
    }
}
