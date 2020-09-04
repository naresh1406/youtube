package main.cp.leetcode.september;

import java.util.ArrayList;
import java.util.List;

public class Day_04_Partition_Labels {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] lastIndex = new int[26];
            for (int i = 0; i < S.length(); i++)
                lastIndex[S.charAt(i) - 'a'] = i;

            List<Integer> result = new ArrayList();
            int j = 0, subStrEnd = 0;
            for (int i = 0; i < S.length(); i++) {
                j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
                if (i == j) {
                    result.add(i - subStrEnd + 1);
                    subStrEnd = i + 1;
                }
            }

            return result;
        }
    }
}
