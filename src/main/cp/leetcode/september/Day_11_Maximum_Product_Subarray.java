package main.cp.leetcode.september;

public class Day_11_Maximum_Product_Subarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int result = nums[0];
            for (int i = 0; i < n; i++) {
                int product = 1;
                for (int j = i; j < n; j++) {
                    product *= nums[j];
                    result = Math.max(result, product);
                }
            }

            return result;
        }
    }

    class Solution2 {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int result = nums[0];
            int curr_max = nums[0];
            int curr_min = nums[0];
            for (int i = 1; i < n; i++) {
                int curr_max_prev = curr_max;
                curr_max = Math.max(nums[i], Math.max(curr_max * nums[i], curr_min * nums[i]));
                curr_min = Math.min(nums[i], Math.min(curr_max_prev * nums[i], curr_min * nums[i]));
                result = Math.max(result, curr_max);
            }

            return result;
        }
    }
}
