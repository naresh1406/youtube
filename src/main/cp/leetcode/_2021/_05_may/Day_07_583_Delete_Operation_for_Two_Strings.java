package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 7/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=YQf-VLs8HDI
 */
public class Day_07_583_Delete_Operation_for_Two_Strings {

    class Solution_EditDistance_TopDown_DP {
        Integer[][] dp;

        public int minDistance(String word1, String word2) {
            dp = new Integer[word1.length()][word2.length()];
            return helper(word1, word2, word1.length() - 1, word2.length() - 1);
        }

        private int helper(String s, String t, int i, int j) {
            if (i < 0)
                return j + 1;
            if (j < 0)
                return i + 1;
            if (dp[i][j] != null)
                return dp[i][j];
            if (s.charAt(i) == t.charAt(j))
                return dp[i][j] = helper(s, t, i - 1, j - 1);
            else
                return dp[i][j] = 1 + Math.min(helper(s, t, i - 1, j), helper(s, t, i, j - 1));
        }
    }

    class Solution_EditDistance_BottomUp_DP {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = word1.charAt(i) == word2.charAt(j) ? dp[i][j] : 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }

            return dp[m][n];
        }
    }


    class Solution_LCS_TopDown_DP {
        Integer[][] dp;

        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            dp = new Integer[m][n];
            return m + n - 2 * helper(word1, word2, m - 1, n - 1);
        }

        private int helper(String s, String t, int i, int j) {
            if (i < 0 || j < 0)
                return 0;
            if (dp[i][j] != null)
                return dp[i][j];
            if (s.charAt(i) == t.charAt(j))
                return dp[i][j] = 1 + helper(s, t, i - 1, j - 1);
            else
                return dp[i][j] = Math.max(helper(s, t, i - 1, j), helper(s, t, i, j - 1));
        }
    }

    class Solution_LCS_BottomUP_DP {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 0;
                    else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

            return m + n - 2 * dp[m][n];
        }
    }
}
