package main.cp.leetcode._2021._03_march;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 3/3/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=9ruqCVH6Dz4
 */
public class Day_03_268_Missing_Number {
    // TC - O(n), SC - O(1)
    class Solution {
        public int missingNumber(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int n = nums.length;
            return (n * (n + 1)) / 2 - sum;
            // return (nums.length * (nums.length + 1)) / 2 - Arrays.stream(nums).sum();
        }
    }

    // TC - O(n), SC - O(1)
    // Similar to Single Number using XOR
    class Solution2 {
        public int missingNumber(int[] nums) {
            int missing = nums.length;
            for (int i = 0; i < nums.length; i++)
                missing ^= i ^ nums[i];

            return missing;
        }
    }
}
