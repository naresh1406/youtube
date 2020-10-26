package main.cp.leetcode.october;

/**
 * Detailed Video Explanation https://www.youtube.com/watch?v=iuHLaYMeuQEs
 */
public class Day_25_1510_Stone_Game_IV {
    // Top Down DP
    class Solution {
        Boolean[] dp = new Boolean[100001];

        public boolean winnerSquareGame(int n) {
            if (n == 0) return false;
            if (dp[n] != null) return dp[n];
            boolean winner = false;
            for (int i = 1; i * i <= n; i++) {
                if (!winnerSquareGame(n - i * i)) {
                    winner = true;
                    break;

                }
            }
            return dp[n] = winner;
        }
    }

    // Bottom Up DP
    class Solution2 {
        public boolean winnerSquareGame(int n) {
            boolean dp[] = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    if (!dp[i - j * j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }
    }
}
