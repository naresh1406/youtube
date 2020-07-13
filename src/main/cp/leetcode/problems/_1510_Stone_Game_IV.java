package main.cp.leetcode.problems;

public class _1510_Stone_Game_IV {
    class Recursive {
        Boolean[] dp = new Boolean[100001];

        public boolean winnerSquareGame(int n) {
            if (n == 0) return false;
            if (dp[n] != null) return dp[n];
            boolean winner = false;
            for (int i = 1; i * i <= n; i++) {
                if (!winnerSquareGame(n - i * i)) {
                    return true;
                }
            }
            return dp[n] = winner;
        }
    }

    class TopDownDP {
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

    class BottomUpDP {
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
