package main.cp.leetcode.december;

import sun.jvm.hotspot.memory.Space;

/**
 * Created by Naresh Gupta on 22/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/xZ5FBqk-cFw?t=0
 */
public class Day_18_334_Increasing_Triplet_Subsequence {
    // O(n) Time and O(1) Space

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n <= first)
                    first = n;
                else if (n <= second)
                    second = n;
                else return true;
            }
            return false;
        }
    }

    // O(n) Time and O(n) Space

    class Solution2 {
        public boolean increasingTriplet(int[] nums) {
            int n = nums.length;
            if (n < 3)
                return false;

            int[] leftMin = new int[n];
            leftMin[0] = nums[0];
            for (int i = 1; i < n; i++)
                leftMin[i] = Math.min(leftMin[i - 1], nums[i]);

            int[] rightMax = new int[n];
            rightMax[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--)
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);

            for (int i = 0; i < n; i++)
                if (leftMin[i] < nums[i] && nums[i] < rightMax[i])
                    return true;

            return false;
        }
    }
}
