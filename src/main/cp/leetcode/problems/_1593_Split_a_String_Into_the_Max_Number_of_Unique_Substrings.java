package main.cp.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class _1593_Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
    class Solution {
        public int maxUniqueSplit(String s) {
            return helper(s, new HashSet());
        }

        private int helper(String s, Set<String> set) {
            int max = 0;
            for (int i = 1; i <= s.length(); i++) {
                String candidate = s.substring(0, i);
                if (!set.contains(candidate)) {
                    set.add(candidate);
                    max = Math.max(max, 1 + helper(s.substring(i), set));
                    set.remove(candidate); // backtrack and try other splits
                }
            }
            return max;
        }
    }
}
