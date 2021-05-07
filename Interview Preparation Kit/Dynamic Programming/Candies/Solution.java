import static java.lang.Math.*;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    static class Foo57 {
        void main() {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                String s = br.readLine().trim();
                int n = Integer.parseInt(s);
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    s = br.readLine().trim();
                    arr[i] = Integer.parseInt(s);
                }
                long res = foo(arr);
                System.out.println(res);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try { br.close(); } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }
        long foo(int[] arr) {
            int n = arr.length;
            if (n == 1)
                return 1L;
            int[] res = new int[n];
            boolean[] vis = new boolean[n];
            Arrays.fill(res, 1);
            Queue<Integer> queue = new ArrayDeque<Integer>();
            if (arr[0] <= arr[1]) {
                queue.add(0);
                vis[0] = true;
            }
            if (arr[n-1] <= arr[n-2]) {
                queue.add(n-1);
                vis[n-1] = true;
            }
            for (int i = 1; i < n-1; i++) {
                if (arr[i] <= arr[i-1] && arr[i] <= arr[i+1]) {
                    queue.add(i);
                    vis[i] = true;
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.remove();
                // check left
                int left = curr-1;
                if (left >= 0 && canAdd(left, arr, res, vis)) {
                    queue.add(left);
                }
                // check right
                int right = curr+1;
                if (right < n && canAdd(right, arr, res, vis)) {
                    queue.add(right);
                }
            }
            long result = 0;
            for (int val : res) {
                result += val;
            }
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(res));
//            System.out.println(Arrays.toString(vis));
            
            return result;
        }
        boolean canAdd(int index, int[] arr, int[] res, boolean[] vis) {
            if (vis[index]) return false;
            if (index-1 >= 0 && !vis[index-1] && arr[index-1] < arr[index])
                return false;
            if (index+1 < arr.length && !vis[index+1] && arr[index+1] < arr[index])
                return false;
            vis[index] = true;
            int val = 1;
            if (index-1 >= 0 && arr[index-1] < arr[index])
                val = max(val, res[index-1]+1);
            if (index+1 < arr.length && arr[index+1] < arr[index])
                val = max(val, res[index+1]+1);
            res[index] = val;
            return true;
        }
    }
    
    public static void main(String[] args) {
        Foo57 foo = new Foo57();
        foo.main();
    }
}
