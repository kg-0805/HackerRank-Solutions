import java.io.*;
import java.util.*;

public class Solution {

    public static int square( int n ){
        return (n * n);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println( square(num) );
    }
}