package main.cp.leetcode._2021._03_march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 3/3/2021 AD.
 * Detailed Video Explaantion - https://www.youtube.com/watch?v=EpMeQJofSZ4
 */
public class Day_02_645_Set_Mismatch {
    // Optimal - TC - O(n), SC - O(1)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            int duplicate = -1, missing = -1;
            for (int num : nums) {
                if (nums[Math.abs(num) - 1] < 0)
                    duplicate = Math.abs(num);
                else
                    nums[Math.abs(num) - 1] *= -1;
            }

            for (int i = 0; i < nums.length; i++)
                if (nums[i] > 0)
                    missing = i + 1;

            return new int[]{duplicate, missing};
        }
    }

    // HashSet - TC - O(n), SC - O(n)
    class Solution2 {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            int diff = (n * (n + 1)) / 2 - Arrays.stream(nums).sum();

            int duplicate = 0;
            Set<Integer> set = new HashSet();
            for (int num : nums) {
                if (set.contains(num)) {
                    duplicate = num;
                    break;
                }
                set.add(num);
            }

            return new int[]{duplicate, duplicate + diff};
        }
    }
}
