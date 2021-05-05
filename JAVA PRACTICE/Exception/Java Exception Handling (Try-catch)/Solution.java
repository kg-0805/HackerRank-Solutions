import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a/b);            
        } catch (java.util.InputMismatchException ime) {
            System.out.println("java.util.InputMismatchException");
        } catch (java.lang.ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }        
    }
}
