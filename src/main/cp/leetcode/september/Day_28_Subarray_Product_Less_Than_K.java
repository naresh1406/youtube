package main.cp.leetcode.september;

public class Day_28_Subarray_Product_Less_Than_K {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) return 0;
            int count = 0, left = 0, right = 0, prod = 1;
            while (right < nums.length) {
                prod *= nums[right];
                while (prod >= k) prod /= nums[left++];
                count += 1 + (right - left);
                right++;
            }
            return count;
        }
    }

    class Solution2 {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            int count = 0, n = nums.length;
            for (int left = 0; left < n; left++) {
                int prod = 1;
                for (int right = left; right < n; right++) {
                    prod *= nums[right];
                    if (prod < k) count++;
                    else break;
                }
            }
            return count;
        }
    }
}
