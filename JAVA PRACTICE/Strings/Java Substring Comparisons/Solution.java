import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String sequence = s.substring(0, k);
        String smallest = sequence;
        String largest = sequence;

    // Complete the function

    for(int i = 1; i <= (s.length() - k); i++){
        sequence = s.substring(i, (i + k));

        if(sequence.compareTo(smallest) < 0){
            smallest = sequence;
        }
        if(sequence.compareTo(largest) > 0){
            largest = sequence;
        }            
    }

    return smallest + "\n" + largest;
    }

