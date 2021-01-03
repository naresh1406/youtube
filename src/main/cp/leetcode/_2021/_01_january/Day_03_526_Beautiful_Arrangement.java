package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 3/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=djbE1cbJR9g
 */
public class Day_03_526_Beautiful_Arrangement {
    // TC - O(n!)

    class Solution {
        int count = 0;

        public int countArrangement(int n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = i + 1;
            permute(nums, 0);
            return count;
        }

        private void permute(int[] nums, int k) {
            if (k == nums.length && isValid(nums))
                count++;
            for (int i = k; i < nums.length; i++) {
                swap(nums, i, k);
                permute(nums, k + 1);
                swap(nums, i, k);
            }
        }

        private boolean isValid(int[] nums) {
            for (int k = 1; k <= nums.length; k++)
                if (nums[k - 1] % k != 0 && k % nums[k - 1] != 0)
                    return false;
            return true;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    // TC - O(M) --> M number Beautiful Arrangement

    class Solution2 {
        int count = 0;

        public int countArrangement(int n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = i + 1;
            permute(nums, 0);
            return count;
        }

        private void permute(int[] nums, int k) {
            if (k == nums.length)
                count++;
            for (int i = k; i < nums.length; i++) {
                swap(nums, i, k);
                if (nums[k] % (k + 1) == 0 || (k + 1) % nums[k] == 0)
                    permute(nums, k + 1);
                swap(nums, i, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
