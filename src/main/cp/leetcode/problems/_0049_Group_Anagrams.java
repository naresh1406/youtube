package main.cp.leetcode.problems;

import java.util.*;

/**
 * Created by Naresh Gupta on 20/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=6B5P1uI5e2E
 */
public class _0049_Group_Anagrams {
    class Solution {
        // TC - O(n * d log d)
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap();
            for (String s : strs) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                String key = new String(c);
                map.computeIfAbsent(key, k -> new ArrayList()).add(s);
            }

            return new ArrayList(map.values());
        }
    }
}
