package main.cp.leetcode.september;

import java.util.HashSet;
import java.util.Set;

public class Day_16_Maximum_XOR_of_Two_Numbers_in_an_Array {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int mask = 0, max = 0;
            for (int i = 31; i >= 0; i--) {
                mask = mask | (1 << i);
                Set<Integer> set = new HashSet();
                for (int num : nums)
                    set.add(mask & num);

                int tmp = max | (1 << i);
                for (int prefix : set) {
                    if (set.contains(tmp ^ prefix)) {
                        max = tmp;
                        break;
                    }
                }
            }

            return max;
        }
    }

    // Naive Brute Force Solution
    class Solution2 {
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length - 1; i++)
                for (int j = i + 1; j < nums.length; j++)
                    max = Math.max(max, nums[i] ^ nums[j]);
            return max;
        }
    }
}
