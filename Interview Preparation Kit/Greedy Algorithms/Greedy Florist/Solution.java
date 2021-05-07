

import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thanhdoan
 */
public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        int n, k;
        n = in.nextInt();
        k = in.nextInt();

        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        Arrays.sort(c);
        
        int result = 0;
        
        if(k >= n){
            for(int i=0;i<n;i++){
                result +=  c[i];
            }
            System.out.println(result);
        }else{
            //Processing
            int x = 0;            
            while(n > 0){                
                for(int i=0;i<k;i++){
                    result += c[n-1]*(x+1);
                    n--;
                    if(n == 0){
                        break;
                    }
                }                
                x++;
            }
            System.out.println(result);
        }        
    }
}
