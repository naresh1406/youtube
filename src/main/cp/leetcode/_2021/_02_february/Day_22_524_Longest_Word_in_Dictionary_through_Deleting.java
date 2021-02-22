package main.cp.leetcode._2021._02_february;

import java.util.Collections;
import java.util.List;

/**
 * Created by Naresh Gupta on 22/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Z71k9PNWNhc
 */
public class Day_22_524_Longest_Word_in_Dictionary_through_Deleting {
    // TC - O(mlogm + mn), m = words in dictionary and n length of stirng s
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            Collections.sort(d, (a, b) -> b.length() == a.length() ? a.compareTo(b) : b.length() - a.length());
            for (String word : d) {
                if (isSubsequence(word, s)) {
                    return word;
                }
            }

            return "";
        }

        private boolean isSubsequence(String word, String s) {
            int j = 0;
            for (int i = 0; i < s.length() && j < word.length(); i++) {
                if (s.charAt(i) == word.charAt(j))
                    j++;
            }

            return j >= word.length();
        }
    }

    // TC - O(mn), m = words in dictionary and n length of stirng s
    class Solution2 {
        public String findLongestWord(String s, List<String> d) {
            Collections.sort(d, (a, b) -> b.length() == a.length() ? a.compareTo(b) : b.length() - a.length());
            for (String word : d) {
                if (isSubsequence(word, s)) {
                    return word;
                }
            }

            return "";
        }

        private boolean isSubsequence(String word, String s) {
            int j = 0;
            for (int i = 0; i < s.length() && j < word.length(); i++) {
                if (s.charAt(i) == word.charAt(j))
                    j++;
            }

            return j >= word.length();
        }
    }
}
