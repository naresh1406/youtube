package main.cp.leetcode.november;

import java.util.*;

/**
 * Created by Naresh Gupta on 12/11/2020 AD.
 */
public class Day_12_47_Permutations_II {

    // TC - O(n * n!)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> result = new HashSet();
            permute(nums, 0, result);
            return new ArrayList(result);
        }

        private void permute(int[] nums, int st, Set<List<Integer>> result) {
            if (st == nums.length)
                result.add(arrayToList(nums));
            for (int i = st; i < nums.length; i++) {
                swap(nums, i, st);
                permute(nums, st + 1, result);
                swap(nums, i, st);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private List<Integer> arrayToList(int[] nums) {
            List<Integer> list = new ArrayList();
            for (int n : nums)
                list.add(n);
            return list;
        }
    }

    // Solution 2 with HashMap frequency to stop many recursive calls.
    class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums)
                map.put(n, map.getOrDefault(n, 0) + 1);
            permuteUniqueHelper(map, new Integer[nums.length], 0, results);
            return results;
        }

        private void permuteUniqueHelper(Map<Integer, Integer> map, Integer[] p, int i, List<List<Integer>> result) {
            if (i == p.length)
                result.add(Arrays.asList(Arrays.copyOf(p, p.length)));
            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    map.put(key, map.get(key) - 1);
                    p[i] = key;
                    permuteUniqueHelper(map, p, i + 1, result);
                    map.put(key, map.get(key) + 1);
                }
            }
        }
    }
}