package main.cp.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class _1577_Number_Of_Ways_Where_Square_Of_Number_Is_Equal_To_Product_Of_Two_Numbers {
    class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            return helper(nums1, nums2) + helper(nums2, nums1);
        }

        private int helper(int[] nums1, int[] nums2) {
            Map<Long, Integer> map = new HashMap();
            for (long n : nums1) map.put(n * n, map.getOrDefault(n * n, 0) + 1);
            int count = 0;
            for (int j = 0; j < nums2.length - 1; j++) {
                for (int k = j + 1; k < nums2.length; k++) {
                    long prod = (long) nums2[j] * nums2[k];
                    if (map.containsKey(prod)) {
                        count += map.get(prod);
                    }
                }
            }
            return count;
        }
    }
}
