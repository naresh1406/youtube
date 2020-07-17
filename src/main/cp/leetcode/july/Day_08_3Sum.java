package main.cp.leetcode.july;

import java.util.*;

/**
 * Day 08 3Sum
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/
 */
public class Day_08_3Sum {
    // 1. Iterative
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
            Arrays.sort(nums); // sort array
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    else if (sum > 0) k--;
                    else if (sum < 0) j++;
                }

            }

            return new ArrayList<>(set);
        }
    }

    // 2. Recursive
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
            Arrays.sort(nums); // sort array
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                helper(nums, i, i + 1, nums.length - 1, set);
            }

            return new ArrayList<>(set);
        }

        private void helper(int[] nums, int i, int j, int k, Set<List<Integer>> set) {
            if (j >= k) return;
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                helper(nums, i, j, k, set);
            } else if (sum > 0) helper(nums, i, j, k - 1, set);
            else helper(nums, i, j + 1, k, set);
        }
    }
}
