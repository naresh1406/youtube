package main.cp.leetcode.july;

import java.util.HashMap;
import java.util.Map;

/**
 * Day_31_Climbing_Stairs
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
 */
public class Day_31_Climbing_Stairs {

    // 1. Recursive
    class Solution {
        public int climbStairs(int n) {
            if (n < 2)
                return 1;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    // 2. Top Down DP
    class Solution2 {
        Map<Integer, Integer> map = new HashMap();

        public int climbStairs(int n) {
            if (n < 2)
                return 1;
            if (map.containsKey(n))
                return map.get(n);
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
            return map.get(n);
        }
    }

    // 3. Bottom Up DP
    class Solution3 {
        public int climbStairs(int n) {
            if (n < 2)
                return 1;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    // 4. Space Optimized Bottom Up DP
    class Solution4 {
        // TC - O(n);
        // SC - O(1);
        public int climbStairs(int n) {
            if (n < 2)
                return 1;
            int first = 1;
            int second = 1;
            int total = 0;
            for (int i = 2; i <= n; i++) {
                total = first + second;
                first = second;
                second = total;
            }

            return total;
        }
    }
}
