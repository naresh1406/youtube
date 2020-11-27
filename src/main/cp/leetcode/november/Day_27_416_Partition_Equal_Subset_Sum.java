package main.cp.leetcode.november;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 27/11/2020 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=y12aWth4TfQ
 */
public class Day_27_416_Partition_Equal_Subset_Sum {
    // Recursive

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum % 2 == 1 ? false : partition(nums, 0, sum / 2);
        }

        private boolean partition(int[] nums, int st, int sum) {
            if (sum == 0)
                return true;
            if (st >= nums.length)
                return false;
            return partition(nums, st + 1, sum - nums[st]) || partition(nums, st + 1, sum);
        }
    }

    // Top Down with Map and Array

    class Solution2 {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum % 2 == 1 ? false : partition(nums, 0, sum / 2);
        }

        Map<String, Boolean> map = new HashMap();

        private boolean partition(int[] nums, int st, int sum) {
            if (sum == 0)
                return true;
            if (st >= nums.length)
                return false;
            String key = sum + " " + st;
            if (!map.containsKey(key))
                map.put(key, partition(nums, st + 1, sum - nums[st]) || partition(nums, st + 1, sum));
            return map.get(key);
        }
    }

    class Solution3 {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum % 2 == 1 ? false : partition(nums, 0, sum / 2, new Boolean[nums.length][sum / 2 + 1]);
        }

        private boolean partition(int[] nums, int st, int sum, Boolean[][] dp) {
            if (sum == 0)
                return true;
            if (sum < 0)
                return false;
            if (st >= nums.length)
                return false;
            if (dp[st][sum] == null)
                dp[st][sum] = partition(nums, st + 1, sum - nums[st], dp) || partition(nums, st + 1, sum, dp);
            return dp[st][sum];
        }
    }

    // Bottom Up

    class Solution4 {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            return sum % 2 == 1 ? false : partition(nums, 0, sum / 2);
        }

        private boolean partition(int[] nums, int st, int sum) {
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1])
                        dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }

            return dp[n][sum];
        }
    }
}
