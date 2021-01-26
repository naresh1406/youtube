package main.cp.leetcode._2021._01_january;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 27/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=i5jcWE3od1U
 */
public class Day_21_1673_Find_the_Most_Competitive_Subsequence {
    // TC - O(n), SC - O(n)
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            Stack<Integer> st = new Stack();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && nums[i] < st.peek() && st.size() + n - i > k)
                    st.pop();
                if (st.size() < k)
                    st.add(nums[i]);
            }

            return st.stream().mapToInt(x -> x).toArray();
        }
    }
}
