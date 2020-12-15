package main.cp.leetcode.december;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 15/12/2020 AD.
 */
public class Day_15_977_Squares_of_a_Sorted_Array {
    class Solution {
        //  TC - O(nLog(n)), SC - O(1)
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++)
                nums[i] *= nums[i];
            Arrays.sort(nums);
            return nums;
        }
    }

    class Solution2 {
        //  TC - O(n), SC - O(n)
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int beg = 0, end = n - 1, i = n - 1;
            while (i >= 0) {
                if (nums[beg] * nums[beg] > nums[end] * nums[end]) {
                    result[i--] = nums[beg] * nums[beg];
                    beg++;
                } else {
                    result[i--] = nums[end] * nums[end];
                    end--;
                }
            }

            return result;
        }
    }
}
