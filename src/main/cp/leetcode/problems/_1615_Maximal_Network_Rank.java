package main.cp.leetcode.problems;

public class _1615_Maximal_Network_Rank {
    // O(n^3) Brute Force
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int rank = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int count = 0;
                    for (int[] road : roads) {
                        if (road[0] == i || road[0] == j || road[1] == i || road[1] == j)
                            count++;
                    }
                    rank = Math.max(rank, count);
                }
            }
            return rank;
        }
    }

    // O(n^2) Optimal
    class Solution2 {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] count = new int[n];
            int[][] direct = new int[n][n];

            for (int[] road : roads) {
                count[road[0]]++;
                count[road[1]]++;
                direct[road[0]][road[1]] = 1;
                direct[road[1]][road[0]] = 1;
            }

            int rank = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    rank = Math.max(rank, count[i] + count[j] - direct[i][j]);
                }
            }

            return rank;
        }
    }
}
