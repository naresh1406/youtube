package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 19/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/3hl6fKIGILY?t=0
 */
public class Day_15_1646_Get_Maximum_in_Generated_Array {
    class Solution {
        public int getMaximumGenerated(int n) {
            if (n < 2)
                return n;

            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;

            int max = 0;
            for (int i = 2; i <= n; i++) {
                nums[i] = nums[i / 2];
                if (i % 2 == 1)
                    nums[i] += nums[i / 2 + 1];
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }
}
