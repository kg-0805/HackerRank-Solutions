import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   
     public static int numberNeeded(String first, String second) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<first.length();i++){
            if(map.get(first.charAt(i)) == null){
                map.put(first.charAt(i), 1);
            } else {
                int cur = map.get(first.charAt(i));
                map.put(first.charAt(i), cur+1);
            }
        }
        for(int i=0;i<second.length();i++){
            if(map.containsKey(second.charAt(i))){
                int cur = map.get(second.charAt(i));
                if(cur == 1){
                   map.remove(second.charAt(i)); 
                } else {
                    map.put(second.charAt(i), cur-1);
                }
            } else {
                count++;
            }
        }
         
        for(Integer i: map.values()){
            count=count+i;
        }
        
        return count;
     }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
