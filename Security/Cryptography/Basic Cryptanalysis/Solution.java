import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<String>[] dictionary;
    static List<String> words;
    static char[] code = new char[26];

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("dictionary.lst"));
        String s;
        dictionary = new List[17];
        for (int i=0; i<17; i++) {
            dictionary[i] = new ArrayList<String>();
        }
        while ((s = fileReader.readLine()) != null) {
            dictionary[s.length()].add(s.toLowerCase());
        }
        Scanner scanner = new Scanner(System.in);
        words = new ArrayList<String>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word.toLowerCase());
        }
        find(0);
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                int c = word.charAt(i)-'a';
                result.append(code[c]);
            }
            result.append(" ");
        }
        System.out.println(result);
    }

    static boolean find(int index) {
        if (index == words.size()) {
            return true;
        }
        String word = words.get(index);
        List<String> list = dictionary[word.length()];
        main: for (String dictWord : list) {
            boolean newCodeInfo = false;
            for (int i=0; i<word.length(); i++) {
                int c = word.charAt(i)-'a';
                char d = dictWord.charAt(i);
                if (code[c] == 0) {
                    newCodeInfo = true;
                } else if (code[c] != d) {
                    continue main;
                }
            }
            if (newCodeInfo) {
                char[] oldCode = code;
                char[] newCode = new char[26];
                System.arraycopy(oldCode, 0, newCode, 0, 26);
                for (int i=0; i<word.length(); i++) {
                    int c = word.charAt(i)-'a';
                    char d = dictWord.charAt(i);
                    if (newCode[c] == 0) {
                        newCode[c] = d;
                    } else if (newCode[c] != d) {
                        continue main;
                    }
                }
                code = newCode;
                boolean ok = find(index+1);
                if (ok) {
                    return true;
                }
                code = oldCode;
            } else {
                boolean ok = find(index+1);
                if (ok) {
                    return true;
                }                
            }
        }
        return false;
    }
    
}
