package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 13/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=RrGv2OPBl8U
 */
public class _0162_Find_Peak_Element {
    class Solution_Linear_Search {
        // TC - O(n)
        public int findPeakElement(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++)
                if (nums[i] > nums[i + 1])
                    return i;
            return nums.length - 1;
        }
    }

    class Solution_Binary_Search {
        // TC - O(logn)
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            return l;
        }
    }
}
