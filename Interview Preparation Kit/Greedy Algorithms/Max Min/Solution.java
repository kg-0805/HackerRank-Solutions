import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numPackets = Integer.parseInt(in.readLine());
        int numKids = Integer.parseInt(in.readLine());
        int[] packets = new int[numPackets];
        
        for(int i = 0; i < numPackets; i ++)
        {
            packets[i] = Integer.parseInt(in.readLine());
        }
        
        int best = Integer.MAX_VALUE;
        
        Arrays.sort(packets);
        for(int j = numKids - 1; j < numPackets; j ++)
        {
            int i = j - numKids + 1;
            int unf = packets[j] - packets[i];
            best = Math.min(best, unf);
        }
        
        System.out.println(best);
    }
}
