import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution {
    
    static private int CACHED_ENTRIES = 50;

    static private double[][] CACHED_DATA;
    static {
        CACHED_DATA = new double[CACHED_ENTRIES + 1][];
        for (int n = 1; n <= CACHED_ENTRIES; n++) {
            CACHED_DATA[n] = new double[n];
            for (int m = 0; m < n; m++) {
                CACHED_DATA[n][m] = evaluateMeanValuePerStick(n, m);
            }
        }
    }

    static private double evaluateMeanValuePerPosition(int n, int m, int k) {
        double mean = 0.0;
        double p = 1.0;
        for (int i = 1; i < k & p > 0; i++) {
            double successp = (double) (m-i+1) / (double) (n-i);
            mean += p * (1 - successp) * (double) i;
            p *= successp;
        }
        mean += p * (double) k;
        return mean;
    }

    static private double evaluateMeanValuePerStick(int n, int m) {
        double total = 0.0;
        for (int k = 1; k <= n; k++)
            total += evaluateMeanValuePerPosition(n, m, k);
        return total / (double) n;
    }

    static private double getMeanValuePerStick(int n, int m) {
        if (n <= CACHED_ENTRIES)
            return CACHED_DATA[n][m];
        else 
            return evaluateMeanValuePerStick(n, m);
    }

    static private void solve(int n, int[] sticks) {
        double total = 0.0;
        for (int i = 1; i <= n; i++) {
            int m = 0;
            for (int j = 1; j <= n; j++)
                if (sticks[i-1] > sticks[j-1]) m++;
            total += getMeanValuePerStick(n, m);
        }
        System.out.println(String.format(Locale.US, "%.2f", total));
    }

    static public void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 16 << 10);
            int testsNumber = Integer.valueOf(br.readLine());
            for (int i = 0; i < testsNumber; i++) {
                int n = Integer.valueOf(br.readLine());
                StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
                int[] sticks = new int[n];
                for (int j = 0; j < n; j++) {
                    sticks[j] = Integer.parseInt(tokenizer.nextToken());
                }
                solve(n, sticks);
            }
        }
        catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}
