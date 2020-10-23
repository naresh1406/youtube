package main.cp.leetcode.october;

import java.util.Stack;

public class Day_23_456_132_Pattern {
    // O(n) - AC
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            int[] min = new int[n];
            min[0] = nums[0];
            for (int i = 1; i < n; i++)
                min[i] = Math.min(min[i - 1], nums[i]);

            Stack<Integer> stack = new Stack<>();
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > min[j]) {
                    while (!stack.isEmpty() && stack.peek() <= min[j])
                        stack.pop();
                    if (!stack.isEmpty() && stack.peek() < nums[j])
                        return true;
                    stack.push(nums[j]);
                }
            }
            return false;
        }
    }

    // O(n^2) - AC
    class Solution2 {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            int leftMin = nums[0];
            for (int j = 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] > leftMin && nums[j] > nums[k])
                        return true;
                }
                leftMin = Math.min(nums[j], leftMin);
            }
            return false;
        }
    }

    // O(n^3) - TLE
    class Solution3 {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n - 2; i++)
                for (int j = i + 1; j < n - 1; j++)
                    for (int k = j + 1; k < n; k++)
                        if (nums[k] > nums[i] && nums[j] > nums[k])
                            return true;
            return false;
        }
    }
}
