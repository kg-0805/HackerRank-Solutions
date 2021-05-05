import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        boolean isByte; boolean isShort; boolean isInt; boolean isLong;
        Scanner in = new Scanner(System.in);
        String cs;
        int cases=in.nextInt();
        while(cases-->0){
           cs=in.next();
           boolean possible = isByte(cs) || isShort(cs) || isLong(cs) || isInt(cs);
            if(possible){
                System.out.println(cs+" can be fitted in:");
                if(isByte(cs)) System.out.println("* byte");
                if(isShort(cs)) System.out.println("* short");
                if(isInt(cs)) System.out.println("* int");
                if(isLong(cs)) System.out.println("* long");
            }else{
                System.out.println(cs+" can't be fitted anywhere.");
                
            }
           /*System.out.println(isByte(cs));
           System.out.println(isShort(cs));
           System.out.println(isLong(cs));
           System.out.println(isInt(cs));*/
        }
    }
    public static boolean isByte(String s){
        boolean ans=true;
        try {
            byte t1= Byte.parseByte(s);
        } catch (NumberFormatException e) {
            ans=false;
        }
        return ans;
    }
        public static boolean isShort(String s){
        boolean ans=true;
        try {
            short t1= Short.parseShort(s);
        } catch (NumberFormatException e) {
            ans=false;
        }
        return ans;
    }
    public static boolean isInt(String s){
        boolean ans=true;
        try {
            int t1= Integer.parseInt(s);
        } catch (NumberFormatException e) {
            ans=false;
        }
        return ans;
    }
    public static boolean isLong(String s){
        boolean ans=true;
        try {
            long t1= Long.parseLong(s);
        } catch (NumberFormatException e) {
            ans=false;
        }
        return ans;
    }

}