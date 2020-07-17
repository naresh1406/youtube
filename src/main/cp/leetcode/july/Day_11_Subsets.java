package main.cp.leetcode.july;

import java.util.ArrayList;
import java.util.List;

/**
 * Day_11_Subsets
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
 */
public class Day_11_Subsets {
    // 1. Iterative BFS
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            result.add(new ArrayList());
            for (int num : nums) {
                int size = result.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> subset = new ArrayList(result.get(i));
                    subset.add(num);
                    result.add(subset);
                }
            }

            return result;
        }
    }

    // 2. Recursive Backtrack
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            generateSubsets(nums, 0, new ArrayList(), result);
            return result;
        }

        private void generateSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
            result.add(new ArrayList(current));
            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                generateSubsets(nums, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
