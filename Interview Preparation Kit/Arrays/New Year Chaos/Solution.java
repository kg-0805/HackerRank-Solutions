import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*; 
import java.util.*;
import java.util.regex.*;
/*
      br = new BufferedReader(new FileReader("input.txt"));
      pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
      br = new BufferedReader(new InputStreamReader(System.in));
      pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 */


public class Solution {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter pw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //int qq = 1;
        //int qq = Integer.MAX_VALUE;
        int qq = readInt();
        for(int casenum = 1; casenum <= qq; casenum++)    {
            int n = readInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = n; i >= 1; i--) {
                list.add(i);
            }
            int[] want = new int[n];
            for(int i = 0; i < n; i++) {
                want[i] = readInt();
            }
            int ret = 0;
            for(int curr: want) {
                if(list.get(list.size()-1) == curr) {
                    list.remove(list.size()-1);
                }
                else if(list.get(list.size()-2) == curr) {
                    ret++;
                    list.remove(list.size()-2);
                }
                else if(list.get(list.size()-3) == curr) {
                    ret+=2;
                    list.remove(list.size()-3);
                }
                else {
                    ret = -1000000000;
                }
            }
            if(ret < 0) {
                pw.println("Too chaotic");
                continue;
            }
            pw.println(ret);
        }
        exitImmediately();
    }

    private static void exitImmediately() {
        pw.close();
        System.exit(0);
    }

    private static long readLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static String nextLine() throws IOException  {
        if(!br.ready()) {
            exitImmediately();
        }
        st = null;
        return br.readLine();
    }

    private static String nextToken() throws IOException  {
        while(st == null || !st.hasMoreTokens())  {
            if(!br.ready()) {
                exitImmediately();
            }
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
}
