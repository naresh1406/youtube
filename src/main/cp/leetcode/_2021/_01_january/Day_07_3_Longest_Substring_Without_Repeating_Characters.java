package main.cp.leetcode._2021._01_january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Naresh Gupta on 12/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=EoMlfgfUPa0
 */
public class Day_07_3_Longest_Substring_Without_Repeating_Characters {

    // Two Pointer Set
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet();
            int longest = 0, i = 0, j = 0, n = s.length();
            while (i < n && j < n) {
                if (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i++));
                } else {
                    set.add(s.charAt(j++));
                    longest = Math.max(longest, j - i);
                }
            }

            return longest;
        }
    }

    // Two Pointer Map

    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap();
            int longest = 0, i = 0, j = 0, n = s.length();
            while (j < n) {
                if (map.containsKey(s.charAt(j)))
                    i = Math.max(map.get(s.charAt(j)), i);
                map.put(s.charAt(j), j + 1);
                longest = Math.max(longest, j - i + 1);
                j++;
            }
            return longest;
        }
    }

    // Naive O(n^3) **TLE**

    class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int longest = 0, n = s.length();
            for (int i = n; i >= 0; i--) {
                for (int j = 0; j + i <= n; j++) {
                    if (isUniqueCharactersString(s.substring(j, j + i)))
                        return i;
                }
            }
            return 0;
        }

        private boolean isUniqueCharactersString(String s) {
            // return s.chars().boxed().collect(Collectors.toSet()).size() == s.length();
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray())
                set.add(c);

            return set.size() == s.length();
        }
    }
}
