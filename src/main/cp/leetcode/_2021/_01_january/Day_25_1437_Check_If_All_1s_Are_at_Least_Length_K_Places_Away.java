package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 28/1/2021 AD.
 */
public class Day_25_1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away {
    class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            for (int r = 0, l = -100001; r < nums.length; r++) {
                if (nums[r] == 1) {
                    if (r - l - 1 < k)
                        return false;
                    l = r;
                }
            }

            return true;
        }
    }
}
