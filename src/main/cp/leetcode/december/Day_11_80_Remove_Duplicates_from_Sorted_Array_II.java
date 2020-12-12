package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 12/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/Zh0Lzs-ObQI?t=0
 */
public class Day_11_80_Remove_Duplicates_from_Sorted_Array_II {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n < 3)
                return n;
            int i = 2;
            for (int j = i; j < n; j++)
                if (nums[i - 2] != nums[j])
                    nums[i++] = nums[j];

            return i;
        }
    }

    class Solution2 {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int n : nums) {
                if (i < 2 || n != nums[i - 2]) {
                    nums[i++] = n;
                }
            }

            return i;
        }
    }

    class Solution3 {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n < 3)
                return n;
            int i = 2, j = 2;
            while (j < n) {
                if (nums[i - 2] != nums[j])
                nums[i++] = nums[j];
                j++;
            }
            return i;
        }
    }
}
