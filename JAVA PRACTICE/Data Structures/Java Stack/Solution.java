import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            Stack<Character> stack = new Stack<>();
            String line = scanner.nextLine();
            for(char c : line.toCharArray()) {
                if(c == '{' || c == '(' || c == '[') {
                   stack.push(c);
                   continue;
                }                    
                
                if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                
                if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    continue;
                }
                
                if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                
                if(c == '}' || c == ')' || c == ']') {
                    stack.push(c);
                    break;
                }   
            }
            System.out.println(stack.isEmpty());
        }
    }
}
