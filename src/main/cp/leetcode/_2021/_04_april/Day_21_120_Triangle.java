package main.cp.leetcode._2021._04_april;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naresh Gupta on 22/4/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=lAC0_XEglMM
 */
public class Day_21_120_Triangle {
    // Recursive TLE, TC - O(r * 2^c)
    class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            return helper(triangle, 0, 0);
        }

        private int helper(List<List<Integer>> triangle, int r, int c) {
            if (r >= triangle.size())
                return 0;
            return Math.min(helper(triangle, r + 1, c), helper(triangle, r + 1, c + 1)) + triangle.get(r).get(c);
        }
    }

    // Top Down DP cache using Map, TC - O(R * R), SC - O(R * R), R - Number of Rows
    class Solution2 {
        Map<String, Integer> map = new HashMap();

        public int minimumTotal(List<List<Integer>> triangle) {
            return helper(triangle, 0, 0);
        }

        private int helper(List<List<Integer>> triangle, int r, int c) {
            if (r >= triangle.size())
                return 0;
            String key = r + "|" + c;
            if (!map.containsKey(key))
                map.put(key, Math.min(helper(triangle, r + 1, c), helper(triangle, r + 1, c + 1)) + triangle.get(r).get(c));

            return map.get(key);
        }
    }

    // Top Down DP cache using 2D Array, TC - O(R * R), SC - O(R * R), R - Number of Rows
    class Solution3 {
        Integer[][] dp;

        public int minimumTotal(List<List<Integer>> triangle) {
            dp = new Integer[triangle.size()][triangle.size()];
            return helper(triangle, 0, 0);
        }

        Map<String, Integer> map = new HashMap();

        private int helper(List<List<Integer>> triangle, int r, int c) {
            if (r >= triangle.size())
                return 0;
            if (dp[r][c] == null)
                dp[r][c] = Math.min(helper(triangle, r + 1, c), helper(triangle, r + 1, c + 1)) + triangle.get(r).get(c);

            return dp[r][c];
        }
    }

    // Bottom Up DP, TC - O(R * R), SC - O(R), R - Number of Rows
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++)
                dp[i] = triangle.get(n - 1).get(i);
            for (int i = n - 2; i >= 0; i--)
                for (int j = 0; j < i + 1; j++)
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);

            return dp[0];
        }
    }
}
