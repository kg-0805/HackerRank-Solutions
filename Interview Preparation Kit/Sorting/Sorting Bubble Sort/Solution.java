import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       int numberOfSwaps = 0;
        boolean isSorted = false;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int lastIndex = n - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastIndex; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    numberOfSwaps++;
                    isSorted = false;
                }
            }
            lastIndex--;
        }
        System.out.println("Array is sorted in "+numberOfSwaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}
