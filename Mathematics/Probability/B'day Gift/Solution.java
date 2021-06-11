import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    static BufferedReader in = new BufferedReader(new InputStreamReader(
            System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int numS = Integer.parseInt(in.readLine());
        long total = 0;
        
        for(int i = 0; i < numS; i ++)
        {
            total += Integer.parseInt(in.readLine());
        }
        
        System.out.print(total/2);
        if(total%2 != 0)
        {
            System.out.println(".5");
        }
        else
        {
            System.out.println(".0");
        }
    }
}
