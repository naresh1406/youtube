package main.cp.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 2/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=rmxZp7tlT0g
 */
public class _0827_Making_A_Large_Island {
    // TC - O(N ^ 4) - TLE
    class Solution_BF {
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int largest = dfs(grid, 0, 0, new boolean[n][n]);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                        largest = Math.max(largest, dfs(grid, i, j, new boolean[n][n]));
                        grid[i][j] = 0;
                    }
                }
            }

            return largest;
        }

        private int dfs(int[][] grid, int x, int y, boolean[][] visited) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y])
                return 0;
            visited[x][y] = true;
            return 1 + dfs(grid, x + 1, y, visited) +
                    dfs(grid, x - 1, y, visited) +
                    dfs(grid, x, y + 1, visited) +
                    dfs(grid, x, y - 1, visited);
        }
    }

    class Solution {
        // TC - O(N ^ 2)
        public int largestIsland(int[][] grid) {
            int n = grid.length;
            int[] A = new int[n * n + 2];
            int index = 2;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1)
                        A[index] = dfs(grid, i, j, index++);
                }
            }

            boolean hasZero = false;
            int largest = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        hasZero = true;
                        Set<Integer> set = new HashSet();
                        if (i > 0) set.add(grid[i - 1][j]);
                        if (j > 0) set.add(grid[i][j - 1]);
                        if (i < n - 1) set.add(grid[i + 1][j]);
                        if (j < n - 1) set.add(grid[i][j + 1]);

                        int area = 1;
                        for (int k : set)
                            area += A[k];

                        largest = Math.max(largest, area);
                    }
                }
            }

            return hasZero ? largest : n * n;
        }

        private int dfs(int[][] grid, int x, int y, int color) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
                return 0;
            grid[x][y] = color;
            return 1 + dfs(grid, x + 1, y, color) +
                    dfs(grid, x - 1, y, color) +
                    dfs(grid, x, y + 1, color) +
                    dfs(grid, x, y - 1, color);
        }
    }
}
