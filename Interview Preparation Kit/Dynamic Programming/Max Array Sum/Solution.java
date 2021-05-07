import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
     if(arr==null || arr.length==0)
      return 0;
     int n=arr.length;
     if(n==1)
       return arr[0];
      if(n==2)  //Just for clarification  not really need that
       return  Math.max(arr[0],arr[1]);  
    //will hold all max till the i-th location
      int[] g=new int[n];
      int currMax = Math.max(arr[0],arr[1]);
      g[0]=arr[0];
      g[1]=currMax;
      for (int i = 2; i < arr.length; i++) {
           currMax =  Math.max(g[i-2] + arr[i], currMax);
           currMax = Math.max(arr[i], currMax);
           g[i]=currMax; 

        }
    return g[n-1];
   // return IntStream.of(g).max().getAsInt();
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
