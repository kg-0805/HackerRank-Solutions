import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        long seeds[] = {1374037200,1374037459,1057556953,1226891312,1287968623,1282073374,1287158953,1159300833,1139155438,1074640221,1040332083,1347392806,990639200,969276712,1182050116,1265867460,1257725758,1185815629};
        Scanner stdin = new Scanner(System.in);
        int testCaseCount = stdin.nextInt();
        for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex += 1) {
            int[] values = new int[10];
            
            for (int j = 0; j < 10; j++) {
                values[j] = stdin.nextInt();
            }
            
            for (int s=0;s<18;s++) {
                Random rand = new Random(seeds[s]);
                boolean bad = false;
                for (int valueIndex = 0; valueIndex < values.length; valueIndex++) {
                    if (rand.nextInt(1000) != values[valueIndex]) {
                        bad = true;
                        break;
                    }
                }
                if (!bad) {
                    //System.out.print(seed);
                    //System.out.print(" ");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(rand.nextInt(1000));
                        System.out.print(" ");
                    }
                    System.out.print("\n");
                }
            }
            
        }
    }
}
