package main.cp.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class _1525_Number_of_Good_Ways_to_Split_a_String {
    class Solution {
        // TC - O(n)
        // SC - O(n)

        public int numSplits(String s) {
            int n = s.length();
            int[] prefix = new int[n];
            int[] suffix = new int[n];
            Set<Character> preSet = new HashSet();
            Set<Character> sufSet = new HashSet();

            for (int i = 0; i < n; i++) {
                preSet.add(s.charAt(i));
                sufSet.add(s.charAt(n - 1 - i)); // right to left
                prefix[i] = preSet.size();
                suffix[n - 1 - i] = sufSet.size();
            }

            int goodWays = 0;
            for (int i = 1; i < n; i++) {
                if (prefix[i - 1] == suffix[i])
                    goodWays++;
            }

            return goodWays;
        }
    }
}
