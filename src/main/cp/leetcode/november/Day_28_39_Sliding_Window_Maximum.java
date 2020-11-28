package main.cp.leetcode.november;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Naresh Gupta on 28/11/2020 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=9BwZAwrYC7c
 */
public class Day_28_39_Sliding_Window_Maximum {
    // Brute Force / Naive
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] result = new int[n - k + 1];
            for (int i = 0; i <= n - k; i++) {
                int max = nums[i];
                for (int j = i; j < i + k; j++)
                    max = Math.max(max, nums[j]);
                result[i] = max;
            }
            return result;
        }
    }

    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            List<Integer> result = new ArrayList();
            LinkedList<Integer> indexes = new LinkedList();

            for (int i = 0; i < n; i++) {
                while (indexes.size() > 0 && indexes.getFirst() <= i - k)
                    indexes.removeFirst();
                while (indexes.size() > 0 && nums[i] >= nums[indexes.getLast()])
                    indexes.removeLast();
                indexes.addLast(i);
                if (i >= k - 1)
                    result.add(nums[indexes.getFirst()]);
            }

            return result.stream().mapToInt(x -> x).toArray();
        }
    }
}
