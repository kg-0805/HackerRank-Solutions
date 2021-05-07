import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   static long minTime(long[] machines, long goal) {

        Arrays.sort(machines); //sort the machine array
        long max = (machines[machines.length - 1]) * goal;
        long min = 0;
        long result = -1;
        //do a binary tree search
        while(max > min){
            long midValue = (max + min) / 2;
            long unit = 0;
            for(long machine : machines){
                unit += midValue / machine;
            } 

            if(unit < goal) {
                min = midValue + 1;
                result = midValue + 1;
            } else  {
                max = midValue;
                result = midValue; 
            } 


        }

        return result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
