package main.cp.leetcode._2021._01_january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 15/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/F4U1_1_Trqs?t0
 */
public class Day_14_1658_Minimum_Operations_to_Reduce_X_to_Zero {
    // Sliding Window -> TC - O(n), SC - O(1)

    class Solution {
        public int minOperations(int[] nums, int x) {
            int target = Arrays.stream(nums).sum() - x;
            int n = nums.length, windowSize = -1, current = 0;

            for (int right = 0, left = 0; right < n; right++) {
                current += nums[right];
                while (current > target && left <= right)
                    current -= nums[left++];

                if (current == target)
                    windowSize = Math.max(windowSize, right - left + 1);
            }
            return windowSize != -1 ? n - windowSize : -1;
        }
    }

    // Prefix Sum HashMap -> TC - O(n), SC - O(n)

    class Solution2 {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0, sum = 0; i < n && sum <= x; i++) {
                map.put(sum, i);
                sum += nums[i];
            }

            int result = Integer.MAX_VALUE;
            for (int r = n - 1, sum = 0; r >= 0 && sum <= x; r--) {
                if (map.containsKey(x - sum))
                    result = Math.min(result, n - r - 1 + map.get(x - sum));
                sum += nums[r];
            }

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }

    // Top Down DP - TLE

    class Solution3 {
        public int minOperations(int[] nums, int x) {
            System.out.println(Integer.MAX_VALUE);
            int result = operation(nums, x, 0, nums.length - 1);
            return result >= 1000000 ? -1 : result;
        }

        Map<String, Integer> map = new HashMap();

        private int operation(int[] nums, int x, int l, int r) {
            if (x < 0)
                return 1000000;
            if (x == 0)
                return 0;
            String key = x + "|" + l + "|" + r;
            if (map.containsKey(key))
                return map.get(key);
            if (l > r || nums[l] > x && nums[r] > x)
                return 1000000;
            map.put(key, Math.min(operation(nums, x - nums[l], l + 1, r), operation(nums, x - nums[r], l, r - 1)) + 1);
            return map.get(key);
        }
    }

}
