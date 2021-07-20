package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 19/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=VK2KsHkEVJU
 */
public class _0014_Longest_Common_Prefix {
    class Solution_1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";

            String prefix = strs[0];
            for (String s : strs) {
                int i = 0;
                // int j = 0;
                while (i < Math.min(prefix.length(), s.length()) && prefix.charAt(i) == s.charAt(i)) {
                    i++;
                    // j++;
                }

                prefix = s.substring(0, i);
            }

            return prefix;
        }
    }

    class Solution_2 {
        // O(N * minLenght)
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0)
                return "";

            int min = Integer.MAX_VALUE;
            int index = 0;

            for (int i = 0; i < strs.length; i++) {
                if (min < strs[i].length()) {
                    min = strs[i].length();
                    index = i;
                }
            }

            String prefix = strs[index];
            for (String s : strs) {
                int i = 0;
                // int j = 0;
                while (i < Math.min(prefix.length(), s.length()) && prefix.charAt(i) == s.charAt(i)) {
                    i++;
                    // j++;
                }

                prefix = s.substring(0, i);
            }

            return prefix;
        }
    }
}
