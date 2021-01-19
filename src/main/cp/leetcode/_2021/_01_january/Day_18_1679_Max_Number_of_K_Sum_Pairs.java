package main.cp.leetcode._2021._01_january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 19/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/FJP2iG8F-FQ?t=0
 */
public class Day_18_1679_Max_Number_of_K_Sum_Pairs {
    // Solution 1 HashMap same as Two Sum

    class Solution {
        public int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            int count = 0;
            for (int num : nums) {
                if (map.containsKey(k - num) && map.get(k - num) > 0) {
                    count++;
                    map.put(k - num, map.get(k - num) - 1);
                } else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            return count;
        }
    }

    // Solution 2 Sorting + Two Pointer

    class Solution2 {
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int count = 0, left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < k) {
                    left++;
                } else if (nums[left] + nums[right] > k) {
                    right--;
                } else {
                    left++;
                    right--;
                    count++;
                }
            }

            return count;
        }
    }

    // Solution 3 Brute Force TLE

    class Solution3 {
        public int maxOperations(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0)
                    continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0)
                        continue;
                    if (nums[i] + nums[j] == k) {
                        count++;
                        nums[i] = nums[j] = 0;
                        break;
                    }
                }
            }

            return count;
        }
    }
}
