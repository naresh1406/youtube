package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 3/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=ry7p7o6GhFk
 */
public class Day_31_31_Next_Permutation {
    // TC - O(n)

    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1])
                i--;

            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i])
                    j--;

                swapTwo(nums, i, j);
            }

            swapArray(nums, i + 01, nums.length - 1);
        }

        private void swapTwo(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }

        private void swapArray(int[] nums, int l, int r) {
            while (l < r) {
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }
    }
}
