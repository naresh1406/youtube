package main.cp.leetcode.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day_14_Longest_Palindrome {

    // 1. Using Set
    class Solution {
        public int longestPalindrome(String s) {
            Set<Character> set = new HashSet();
            int len = 0;
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    len += 2;
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }

            return set.size() > 0 ? len + 1 : len;
        }
    }

    // 2. Using Map
    class Solution2 {
        public int longestPalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);

            boolean isOddOccurrence = false;
            int longestPalindrome = 0;
            for (int val : map.values()) {
                longestPalindrome += val;
                if (val % 2 == 1)
                    isOddOccurrence = true;
            }

            return isOddOccurrence ? longestPalindrome + 1 : longestPalindrome;
        }
    }
}
