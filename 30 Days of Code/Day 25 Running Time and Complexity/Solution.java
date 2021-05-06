import java.util.*;

public class Solution {
    /**
    *   @param n An integer to be checked.
    *   @return true if n is prime, false if n is not prime.
    **/
    public static boolean isPrime(int n){
        // 1 is not prime
        if( n == 1 ){
            return false;
        }
        
        // return false n is divisible by any i from 2 to n
        int i = 1;
        while( i++ < n/2 ){
            if( n % i == 0 ){
                return false;
            }
        }
        
        // n is prime
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i = 0; i < testCases; i++){
            System.out.println( (isPrime(scan.nextInt()) ? "Prime" : "Not prime") );
        }
        scan.close();
    }
}
