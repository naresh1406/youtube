package main.cp.leetcode.problems;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 28/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=eVS33j13PWY
 */
public class _0016_3Sum_Closest {
    // TC - O(N^3)
    class Solution_1 {
        public int threeSumClosest(int[] nums, int target) {
            int min = Integer.MAX_VALUE;
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int temp = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        if (min > temp) {
                            min = temp;
                            sum = nums[i] + nums[j] + nums[k];
                        }
                    }
                }
            }

            return sum;
        }
    }

    // TC - O(N^2)
    class Solution_2 {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length, result = 0, diff = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                int j = i + 1, k = n - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(diff) > Math.abs(sum - target)) {
                        diff = sum - target;
                        result = sum;
                    }

                    if (sum < target)
                        j++;
                    else
                        k--;
                }
            }

            return result;
        }
    }
}
