package main.cp.leetcode._2021._04_april;

/**
 * Created by Naresh Gupta on 30/4/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=o4HOs48Qblg
 */
public class Day_29_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    // TC - O(log(n)), SC - O(1)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = binarySearch(nums, target, true);
            int right = binarySearch(nums, target, false);

            return new int[]{left, right};
        }

        private int binarySearch(int[] A, int target, boolean leftBias) {
            int l = 0, r = A.length - 1, i = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (A[m] < target)
                    l = m + 1;
                else if (A[m] > target)
                    r = m - 1;
                else {
                    i = m;
                    if (leftBias)
                        r = m - 1;
                    else
                        l = m + 1;
                }
            }

            return i;
        }
    }

    // TC - O(n), SC - O(1)
    class SolutionLinearSearch {
        public int[] searchRange(int[] nums, int target) {
            int left = -1, right = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (left == -1)
                        left = i;
                    right = i;
                }
            }

            return new int[]{left, right};
        }
    }
}
