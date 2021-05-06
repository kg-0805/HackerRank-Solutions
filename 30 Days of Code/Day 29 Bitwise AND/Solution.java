import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            
            int result = 0;
            for (int a = 1; a <= N -1; a++) {
                for (int b = a + 1; b <= N; b++) {
                    int temp = a & b;
                    if (temp < K && temp >= result) {
                        result = temp;
                    }
                }
            }
            System.out.println(result);
        }
        scan.close();
    }
}
