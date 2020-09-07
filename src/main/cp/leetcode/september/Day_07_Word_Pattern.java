package main.cp.leetcode.september;

import java.util.HashMap;
import java.util.Map;

public class Day_07_Word_Pattern {
    class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;
            Map map = new HashMap();
            for (Integer i = 0; i < pattern.length(); i++)
                if (map.put(words[i], i) != map.put(pattern.charAt(i), i))
                    return false;
            return true;
        }
    }

    class Solution2 {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (pattern.length() != words.length)
                return false;
            Map<String, Integer> wordToIndex = new HashMap();
            Map<Character, Integer> charToIndex = new HashMap();
            for (Integer i = 0; i < words.length; i++) {
                if (wordToIndex.put(words[i], i) != charToIndex.put(pattern.charAt(i), i))
                    return false;
            }
            return true;
        }
    }

    class Solution3 {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;
            Map<String, Character> wordToChar = new HashMap();
            Map<Character, String> charToWord = new HashMap();
            for (int i = 0; i < pattern.length(); i++) {
                if (wordToChar.containsKey(words[i]) && wordToChar.get(words[i]) != pattern.charAt(i) ||
                        charToWord.containsKey(pattern.charAt(i)) && !charToWord.get(pattern.charAt(i)).equals(words[i]))
                    return false;
                wordToChar.put(words[i], pattern.charAt(i));
                charToWord.put(pattern.charAt(i), words[i]);
            }
            return true;
        }
    }
}