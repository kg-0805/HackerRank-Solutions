import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] h = new int[6][6];
        for (int i=0;i<6;++i)
            for (int j=0;j<6;++j)
                h[i][j] = sc.nextInt();
            
        int m = -10000;
        for (int i=0;i<=3;++i){
            for (int j=0;j<=3;++j){
                int s = h[i][j] + h[i][j+1] + h[i][j+2] + h[i+1][j+1] + h[i+2][j] + h[i+2][j+1] + h[i+2][j+2];
                if (s>m) m=s;
            }
        }
        System.out.println(m);
    }
}
