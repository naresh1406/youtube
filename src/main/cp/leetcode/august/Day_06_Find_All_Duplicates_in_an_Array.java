package main.cp.leetcode.august;

import java.util.*;

public class Day_06_Find_All_Duplicates_in_an_Array {
    // 1. Arrays sorting
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            Arrays.sort(nums);
            List<Integer> list = new ArrayList();
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1]) {
                    list.add(nums[i]);
                    i++;
                }
            }
            return list;
        }
    }

    // 2. Linear Time & Linear Space using Set
    class Solution2 {
        public List<Integer> findDuplicates(int[] nums) {
            Set<Integer> set = new HashSet();
            List<Integer> list = new ArrayList();
            for (int num : nums) {
                if (set.contains(num))
                    list.add(num);
                set.add(num);
            }
            return list;
        }
    }

    // 3. Linear Time & Constant Space
    class Solution3 {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                int id = Math.abs(nums[i]);
                if (nums[id - 1] < 0)
                    list.add(id);
                else
                    nums[id - 1] = -nums[id - 1];
            }
            return list;
        }
    }
}
