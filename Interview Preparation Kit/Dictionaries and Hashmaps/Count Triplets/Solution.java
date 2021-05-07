import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(mergeSort(arr));
        }
    }
    
    static long mergeSort(int[] a){
        int temp[] = new int[a.length];
        return mergeSort(a, temp, 0, a.length - 1);
    }
    
    static long mergeSort(int[] a, int[] temp, int left, int right){
        long count = 0;
        if(right <= left) return 0;
        int mid = left + (right - left) / 2;
        count += mergeSort(a, temp, left, mid);
        count += mergeSort(a, temp, mid + 1, right);
        count += merge(a, temp, left, mid, right);
        return count;
    }
    
    static long merge(int[] a, int[] temp, int left, int mid, int right){
        long count = 0;
        for(int k = left; k <= right; k++){
            temp[k] = a[k];
        }
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i > mid) a[k] = temp[j++];
            else if(j > right) a[k] = temp[i++];
            else if(temp[j] < temp[i]){
                a[k] = temp[j++];
                count += (mid - i + 1);
            }
            else a[k] = temp[i++];
        }
        return count;
    }
}
