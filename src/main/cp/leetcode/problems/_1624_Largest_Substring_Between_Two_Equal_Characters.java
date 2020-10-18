package main.cp.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1624_Largest_Substring_Between_Two_Equal_Characters {
    // Brute Force O(n^2)
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int largest = -1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        largest = Math.max(largest, j - i - 1);
                    }
                }
            }
            return largest;
        }
    }

    // Two Pass O(n)
    class Solution2 {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] lastIndex = new int[26];
            Arrays.fill(lastIndex, -1);
            for (int i = 0; i < s.length(); i++)
                lastIndex[s.charAt(i) - 'a'] = i;
            int largest = -1;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (lastIndex[c] != -1 && lastIndex[c] != i)
                    largest = Math.max(largest, lastIndex[c] - i - 1);
            }
            return largest;
        }
    }

    // One Pass O(n)
    class Solution3 {
        public int maxLengthBetweenEqualCharacters(String s) {
            Map<Character, Integer> map = new HashMap();
            int largest = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    largest = Math.max(largest, i - map.get(c) - 1);
                } else {
                    map.put(c, i);
                }
            }
            return largest;
        }
    }
}
