package main.cp.leetcode.problems;

public class _1512_Number_of_Good_Pairs {
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int count = 0;
            int[] freq = new int[101];
            for (int num : nums)
                count += freq[num]++;
            return count;
        }
    }
}
