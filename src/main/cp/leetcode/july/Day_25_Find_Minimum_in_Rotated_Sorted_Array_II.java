package main.cp.leetcode.july;

/**
 * Day_25_Find_Minimum_in_Rotated_Sorted_Array_II
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
 */
public class Day_25_Find_Minimum_in_Rotated_Sorted_Array_II {
    class Solution {
        public int findMin(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[r]) l = mid + 1;
                else if (nums[mid] < nums[r]) r = mid;
                else r--;
            }

            return nums[l];
        }
    }
}