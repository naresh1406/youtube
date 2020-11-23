package main.cp.leetcode.problems;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 23/11/2020 AD.
 */
public class _1657_Determine_if_Two_Strings_Are_Close {
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length())
                return false;
            int[] f1 = new int[26], f2 = new int[26];
            boolean[] v1 = new boolean[26], v2 = new boolean[26];

            for (int i = 0; i < word1.length(); i++) {
                f1[word1.charAt(i) - 'a']++;
                f2[word2.charAt(i) - 'a']++;
                v1[word1.charAt(i) - 'a'] = true;
                v2[word2.charAt(i) - 'a'] = true;
            }

            Arrays.sort(f1);
            Arrays.sort(f2);

            return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);
        }
    }
}
