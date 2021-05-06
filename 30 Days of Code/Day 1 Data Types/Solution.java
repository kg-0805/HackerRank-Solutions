import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
/* Declare second integer, double, and String variables. */
        
        int x;
        double y;
        String z = "";
        /* Read and save an integer, double, and String to your variables.*/
        x = Integer.parseInt(scan.next()) + i;
        y = Double.parseDouble(scan.next()) + d;
        /* Print the sum of both integer variables on a new line. */
        System.out.println(x);
        /* Print the sum of the double variables on a new line. */
        System.out.println(y);
        /* Concatenate and print the String variables on a new line; 
            the 's' variable above should be printed first. */
        z+=s;
        while(scan.hasNext()) {
            z += scan.next();
            z += " ";
        }
        
        System.out.println(z);
        scan.close();
    }
}