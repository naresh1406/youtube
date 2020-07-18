package main.cp.leetcode.problems;

import java.util.Arrays;

public class _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {
    class Solution {
        // TC - O(nlogn)
        public int minDifference(int[] nums) {
            int n = nums.length;
            if (n <= 4) return 0;
            Arrays.sort(nums);
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                result = Math.min(result, nums[n - 1 - 3 + i] - nums[i]);
            }
            return result;
        }
    }
}
