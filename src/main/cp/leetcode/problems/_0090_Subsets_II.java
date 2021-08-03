package main.cp.leetcode.problems;

import java.util.*;

/**
 * Created by Naresh Gupta on 3/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=KqYQgmZ3Hq8
 */
public class _0090_Subsets_II {
    class Solution_1 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Set<List<Integer>> result = new HashSet();
            Arrays.sort(nums);
            subsets(nums, 0, new ArrayList(), result);
            return new ArrayList(result);
        }

        private void subsets(int[] nums, int start, List<Integer> list, Set<List<Integer>> result) {
            if (start > nums.length)
                return;
            result.add(list);
            for (int i = start; i < nums.length; i++) {
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[i]);
                subsets(nums, i + 1, newList, result);
            }
        }
    }

    class Solution_2 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(nums);
            subsets(nums, 0, new ArrayList(), result);
            return result;
        }

        private void subsets(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
            if (start > nums.length)
                return;
            result.add(list);
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[i]);
                subsets(nums, i + 1, newList, result);
            }
        }
    }
}
