import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try{
          int numTest = Integer.parseInt(sc.nextLine());
          for(int i = 0; i < numTest; i++){
              
           if(isBalanced(sc.nextLine())){
               System.out.println("YES");
           } else {
               System.out.println("NO");
           }
          }
        } catch(Exception e){
            System.out.println("Invalid Input");
        }
    }
    public static boolean isBalanced(String s){
        if(s == null || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                if(!stack.isEmpty()){
                    char latestOpenP = stack.pop();
                    if(latestOpenP == '(' && c != ')'){
                        return false;
                    } else if(latestOpenP == '{' && c != '}'){
                        return false;
                    } else if(latestOpenP == '[' && c != ']'){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    
        return stack.isEmpty();
    }
}
