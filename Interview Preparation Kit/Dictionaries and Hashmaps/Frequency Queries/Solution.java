import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery (BufferedReader bufferedReader, int q)throws IOException {

        HashMap<Integer, Integer> valuesToCounts = new HashMap<>();
        HashMap<Integer, Set<Integer>> countsToValues = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>(); 
        int size = q;
           
        for (int i = 0; i < q; i++) {
            String[] query = bufferedReader.readLine().split(" ");
            int operation = Integer.parseInt(query[0]);
            int number = Integer.parseInt(query[1]);

            int oldCount = valuesToCounts.getOrDefault(number, 0); 
            int newCount; 

            if (operation == 1) {
                newCount = oldCount + 1; 
                valuesToCounts.put(number, newCount);
                
                if (countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }
                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if (operation == 2) {
                newCount = (oldCount > 1) ? oldCount - 1 : 0;
                valuesToCounts.put(number, newCount);

                if (countsToValues.containsKey(oldCount)) {
                    countsToValues.get(oldCount).remove(number);
                }

                countsToValues.putIfAbsent(newCount, new HashSet<>());
                countsToValues.get(newCount).add(number);
            }

            if (operation == 3) {
                if (number > size) results.add(0);
                else {
                    results.add((number == 0 || countsToValues.getOrDefault(number, Collections.emptySet()).size() > 0) ? 1 : 0);
                }
            }
        }

        return results; 
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in))) {
            
            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ans = freqQuery(bufferedReader, q); 
          
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH")))) {
            
                bufferedWriter.write(ans.stream().map(Object::toString)
                            .collect(joining("\n")) + "\n");
            }
        }
    }
}
