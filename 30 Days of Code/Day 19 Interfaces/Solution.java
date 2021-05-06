import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
   int divisorSum(int n);
}
class Calculator implements AdvancedArithmetic{
    public int divisorSum(int n){
        // n has no divisors other than itself
        if(n == 1){
            return n;
        }
        
        // Find and sum divisors:
        int half = n/2;
        int sum = n;
        do{
            if(n % half == 0){
                sum += half;
            }
        }while( half-- > 1 );
        
        return sum;
    }
}
class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }
}