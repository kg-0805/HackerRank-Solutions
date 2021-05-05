import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N%2==1)
            System.out.println("Weird");
        else
            {
            if(N>=2&&N<=5)
                System.out.println("Not Weird");
            else if(N<=20)
                System.out.println("Weird");
                else
                System.out.println("Not Weird");
        }
    }
}