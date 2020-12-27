package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 27/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/yHx2TyGRqQM?t=0
 */
public class Day_26_91_Decode_Ways {
    // Top Down DP
    class Solution {
        public int numDecodings(String s) {
            return helper(s, 0, new Integer[s.length()]);
        }

        private int helper(String s, int i, Integer[] dp) {
            if (i >= s.length())
                return 1;
            if (s.charAt(i) == '0')
                return 0;
            if (dp[i] != null)
                return dp[i];
            int ways = helper(s, i + 1, dp);
            if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26)
                ways += helper(s, i + 2, dp);
            return dp[i] = ways;
        }
    }

    // Bottom UP DP
    class Solution2 {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0)
                return 0;

            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for (int i = 2; i < dp.length; i += 1) {
                if (s.charAt(i - 1) != '0')
                    dp[i] += dp[i - 1];

                int twoDigit = Integer.valueOf(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26)
                    dp[i] += dp[i - 2];
            }

            return dp[s.length()];
        }
    }
}
