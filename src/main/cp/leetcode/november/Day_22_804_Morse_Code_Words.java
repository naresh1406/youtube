package main.cp.leetcode.november;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 22/11/2020 AD.
 */
public class Day_22_804_Morse_Code_Words {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            Set<String> set = new HashSet();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (char c : word.toCharArray())
                    sb.append(code[c - 'a']);
                set.add(sb.toString());
            }
            return set.size();
        }
    }
}
