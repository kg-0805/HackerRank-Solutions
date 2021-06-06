import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int gcd(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;            
        }
        return a;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();                        
            int t = Math.max(a, b);
            a = Math.min(a, b);
            b = t;            
            int nu, de;
            if (a == 0 && b <= c) {                
                nu = de = 1;                
            } else if (a == 0 && b > c) {
                nu = c;
                de = b;
            } else if (a < c && b >= c) {
                nu = 2 * c - a;
                de = 2 * b;
            } else if (b < c && a < c && c < (a + b)) {
                nu = 2 * a * b - (a + b - c) * (a + b - c);
                de = 2 * a * b;
            }
            else {
                nu = c * c;
                de = 2 * a * b;
            }
            if (nu >= de)
                nu = de = 1;
            int gcd = gcd(nu, de);
            nu /= gcd;
            de /= gcd;
            System.out.println(nu + "/" + de);
        }
    }
}
