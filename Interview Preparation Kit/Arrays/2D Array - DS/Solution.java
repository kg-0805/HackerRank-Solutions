import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[6][6];
        for (int y = 0; y < 6; y++){
            for (int x =0; x<6; x++){
                array[x][y] = sc.nextInt();
            }
        }
        int maxHourglass = getHourglass(array, 1,1);
        for (int y=1; y<5; y++){
            for (int x=1; x<5; x++){
                int hourres = getHourglass(array, x, y);
                if (hourres > maxHourglass){
                    maxHourglass = hourres;
                }
            }
        }
        System.out.println(maxHourglass);
    }
    
    public static int getHourglass(int[][] array, int x, int y) {
        return array[x][y] + array[x-1][y-1] + array[x][y-1] + array[x+1][y-1] + array[x-1][y+1]
            + array[x][y+1] + array[x+1][y+1];
    }
}
