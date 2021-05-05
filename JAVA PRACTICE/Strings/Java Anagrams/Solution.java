import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String A, String B) {
        if(A.length() != B.length())return false;
       A=A.toLowerCase();
       B=B.toLowerCase();
       int []countsA=new int[28];
       int []countsB=new int[28];
       for(int i=0;i<28;i++)
           countsA[i]=countsB[i]=0;
       for(int i=0;i<A.length();i++){
           countsA[A.charAt(i)-'a']++;
           countsB[B.charAt(i)-'a']++;
       }
       for(int i=0;i<28;i++)
           if(countsA[i]!=countsB[i])return false;
       return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}