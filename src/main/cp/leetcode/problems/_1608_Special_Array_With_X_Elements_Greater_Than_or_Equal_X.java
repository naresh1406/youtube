package main.cp.leetcode.problems;

import java.util.Arrays;

public class _1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    class Solution {
        public int specialArray(int[] nums) {
            for (int i = 1; i < 1001; i++) {
                int count = 0;
                for (int num : nums) {
                    if (num >= i)
                        count++;
                }
                if (i == count)
                    return i;
            }
            return -1;
        }
    }

    static class Solution2 {
        public static int specialArray(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i <= nums[nums.length - 1]; i++) {
                int ind = Arrays.binarySearch(nums, i);
                System.out.println(ind);
                if (ind >= 0 &&  i == nums.length - ind)
                    return i;
            }
            return -1;
        }

        public static void main(String[] args) {
            System.out.println(specialArray(new int[]{3, 6, 7, 7, 0}));
        }
    }
}
