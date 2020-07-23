package main.cp.leetcode.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Day_23_Single_Number_III
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
 */
public class Day_23_Single_Number_III {
    // 1. Sorting
    class Solution {
        public int[] singleNumber(int[] nums) {
            int[] result = new int[2];
            int index = 0;
            int n = nums.length;

            Arrays.sort(nums);
            if (nums[0] != nums[1]) result[index++] = nums[0];
            if (nums[n - 1] != nums[n - 2]) result[index++] = nums[n - 1];

            for (int i = 1; i < n - 1; i++)
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1])
                    result[index++] = nums[i];

            return result;
        }
    }

    // 2. HashMap Frequency
    class Solution2 {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap();
            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            int[] result = new int[2];
            int index = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet())
                if (e.getValue() == 1)
                    result[index++] = e.getKey();

            return result;
        }
    }

    // 3. Bitwise XOR
    class Solution3 {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int n : nums) xor ^= n;
            int mask = (xor & (xor - 1)) ^ xor; // int mask = xor & -xor;

            int num1 = 0;
            for (int n : nums)
                if ((mask & n) == 0)
                    num1 ^= n;

            return new int[]{num1, xor ^ num1};
        }
    }
}