package main.cp.leetcode.september;

public class Day_14_House_Robber {
    class Solution {
        public int rob(int[] nums) {
            return rob(nums, nums.length - 1);
        }

        private int rob(int[] nums, int i) {
            if (i < 0)
                return 0;
            return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        }
    }

    class Solution2 {
        Integer[] dp;

        public int rob(int[] nums) {
            dp = new Integer[nums.length];
            return rob(nums, nums.length - 1);
        }

        private int rob(int[] nums, int i) {
            if (i < 0) return 0;
            if (dp[i] != null) return dp[i];
            return dp[i] = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        }
    }

    class Solution3 {
        public int rob(int[] nums) {
            int two = 0, one = 0, max_amount = 0;
            for (int num : nums) {
                max_amount = Math.max(two + num, one);
                two = one;
                one = max_amount;
            }
            return max_amount;
        }
    }
}
