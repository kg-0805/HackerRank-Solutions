import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String key, text;
        Chiper chp;
        while (0 < T--) {
            key = sc.nextLine().trim();
            text = sc.nextLine().trim();
            chp = new Chiper(key);
            chp.decode(text);
        }
    }
}

class Chiper {
    private char[] alphabets = new char[26];
    private ArrayList<Character> lookUp = new ArrayList<Character>();
    private ArrayList<Character> alphaList = new ArrayList<Character>(26);

    Chiper(String key) {
        //generate the alphabet list for operations
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabets[(int) c - 65] = c;
            alphaList.add(c);
        }

        int len = key.length();
        char pres;
        ArrayList<Character> inputs = new ArrayList<Character>();
        ArrayList<Character> sortList = new ArrayList<Character>();
        for (int i = 0; i < len; i++) {
            pres = key.charAt(i);
            if (inputs.indexOf(pres) == -1) {
                inputs.add(pres);
                sortList.add(pres);
            }
        }
        Collections.sort(sortList);
        alphaList.removeAll(sortList);
        generateLookUp(inputs, sortList);
    }

    private void generateLookUp(ArrayList<Character> inputs, ArrayList<Character> sortList) {
        int size = sortList.size(), len = alphaList.size(), offset;
        char now;
        for (int j = 0; j < size; j++) {
            now = sortList.get(j);
            lookUp.add(now);
            offset = inputs.indexOf(now);
            for (int i = offset; i < len; i += size) {
                lookUp.add(alphaList.get(i));
            }
        }
    }

    void decode(String code) {
        StringBuilder sb = new StringBuilder("");
        int len = code.length();
        char pres;
        for (int i = 0; i < len; i++) {
            pres = code.charAt(i);
            if (pres == ' ') {
                sb.append(pres);
            } else {
                sb.append(alphabets[lookUp.indexOf(pres)]);
            }
        }
        System.out.println(sb.toString());
    }
}
