package main.cp.leetcode.september;

import java.util.TreeSet;

public class Day_02_Contains_Duplicate_III {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(1L * nums[i] - nums[j]) <= t && j - i <= k)
                        return true;
                }
            }
            return false;
        }
    }

    // 2.
    class Solution2 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums.length == 0 || k <= 0)
                return false;

            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long floor = set.floor(1L * nums[i] + t);
                Long ceil = set.ceiling(1L * nums[i] - t);
                if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
                    return true;

                set.add(1L * nums[i]);
                if (i >= k)
                    set.remove(1L * nums[i - k]);
            }

            return false;
        }
    }
}
