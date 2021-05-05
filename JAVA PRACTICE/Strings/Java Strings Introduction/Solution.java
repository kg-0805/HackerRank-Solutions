    import java.io.*;
    import java.util.*;
    import java.text.*;
    import java.math.*;
    import java.util.regex.*;

    public class Solution {

        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            String B=sc.next();
            System.out.println(A.length()+B.length());
            if(A.compareTo(B)<=0)System.out.println("No");
            else System.out.println("Yes");
            System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1)+" "+B.substring(0, 1).toUpperCase() + B.substring(1));
        }
    }
