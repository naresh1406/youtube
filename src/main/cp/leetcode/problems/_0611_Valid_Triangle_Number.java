package main.cp.leetcode.problems;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 19/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=MfjNrTasq38
 */
public class _0611_Valid_Triangle_Number {

    // Brute Force - TLE, TC - O(N^3)
    class Solution_1 {
        public int triangleNumber(int[] nums) {
            int n = nums.length;
            int count = 0;

            for (int i = 0; i < n - 2; i++)
                for (int j = i + 1; j < n - 1; j++)
                    for (int k = j + 1; k < n; k++)
                        if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
                            count++;

            return count;
        }
    }

    // TC - O(N^2)
    class Solution {
        public int triangleNumber(int[] nums) {
            int n = nums.length;
            int count = 0;
            Arrays.sort(nums);
            for (int i = n - 1; i >= 2; i--) {
                int j = 0, k = i - 1;
                while (j < k) {
                    if (nums[j] + nums[k] > nums[i]) {
                        count += k - j;
                        k--;
                    } else {
                        j++;
                    }
                }
            }

            return count;
        }
    }
}
