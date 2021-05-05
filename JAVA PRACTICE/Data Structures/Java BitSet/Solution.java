import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        BitSet[] a = new BitSet[] {null, new BitSet(n), new BitSet(n)};
        int m = sc.nextInt();
        
        for (int k = 0; k < m; k++) {
            String cmd = sc.next();
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            if (cmd.equals("AND")) {
                a[k1].and(a[k2]);
            } else if (cmd.equals("OR")) {
                a[k1].or(a[k2]);
            } else if (cmd.equals("XOR")) {
                a[k1].xor(a[k2]);
            } else if (cmd.equals("FLIP")) {
                a[k1].flip(k2);
            } else if (cmd.equals("SET")) {
                a[k1].set(k2);
            }
            System.out.println(a[1].cardinality() + " " + a[2].cardinality());
        }
    }
}
