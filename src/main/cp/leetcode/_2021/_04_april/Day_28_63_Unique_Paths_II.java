package main.cp.leetcode._2021._04_april;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 30/4/2021 AD.
 * Detailed Video Explanation- https://www.youtube.com/watch?v=g1BMNXpv31Y
 */
public class Day_28_63_Unique_Paths_II {
    // TC - O(mn), SC - O(m)
    class SolutionBottomUpSpaceOptimize {
        public int uniquePathsWithObstacles(int[][] A) {
            int m = A.length, n = A[0].length;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int[] row : A) {
                for (int j = 0; j < n; j++) {
                    if (row[j] == 1)
                        dp[j] = 0;
                    else if (j > 0)
                        dp[j] += dp[j - 1];
                }
            }

            return dp[n - 1];
        }
    }

    // TC - O(mn), SC - O(mn)
    class SolutionBottomUp {
        public int uniquePathsWithObstacles(int[][] A) {
            int m = A.length, n = A[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0)
                        dp[i][j] = A[i][j] ^ 1;
                    else if (i == 0)
                        dp[i][j] = A[i][j] == 1 ? 0 : dp[i][j - 1];
                    else if (j == 0)
                        dp[i][j] = A[i][j] == 1 ? 0 : dp[i - 1][j];
                    else
                        dp[i][j] = A[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    // TC - O(mn), SC - O(mn)
    class SolutionTopDownWithArray {
        Integer[][] dp;

        public int uniquePathsWithObstacles(int[][] A) {
            dp = new Integer[A.length][A[0].length];
            return countPaths(A, 0, 0);
        }

        private int countPaths(int[][] A, int i, int j) {
            if (i == A.length - 1 && j == A[0].length - 1 || A[i][j] == 1)
                return A[i][j] ^ 1;
            if (dp[i][j] != null)
                return dp[i][j];
            if (i == A.length - 1)
                return dp[i][j] = countPaths(A, i, j + 1);
            if (j == A[0].length - 1)
                return dp[i][j] = countPaths(A, i + 1, j);
            return dp[i][j] = countPaths(A, i + 1, j) + countPaths(A, i, j + 1);
        }
    }

    // TC - O(mn), SC - O(mn)
    class SolutionTopDownWithMap {
        Map<String, Integer> map = new HashMap();

        public int uniquePathsWithObstacles(int[][] A) {
            return countPaths(A, 0, 0);
        }

        private int countPaths(int[][] A, int i, int j) {
            if (i == A.length - 1 && j == A[0].length - 1 || A[i][j] == 1)
                return A[i][j] ^ 1;
            String key = i + "|" + j;
            if (map.containsKey(key))
                return map.get(key);
            int count = 0;
            if (i == A.length - 1)
                count = countPaths(A, i, j + 1);
            else if (j == A[0].length - 1)
                count = countPaths(A, i + 1, j);
            else
                count = countPaths(A, i + 1, j) + countPaths(A, i, j + 1);

            map.put(key, count);
            return count;
        }
    }

    class SolutionRecursive {
        public int uniquePathsWithObstacles(int[][] A) {
            return countPaths(A, 0, 0);
        }

        private int countPaths(int[][] A, int i, int j) {
            if (i == A.length - 1 && j == A[0].length - 1 || A[i][j] == 1)
                return A[i][j] ^ 1;
            if (i == A.length - 1)
                return countPaths(A, i, j + 1);
            if (j == A[0].length - 1)
                return countPaths(A, i + 1, j);
            return countPaths(A, i + 1, j) + countPaths(A, i, j + 1);
        }
    }
}
