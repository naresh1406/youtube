package main.cp.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Detailed Video Explanation**https://www.youtube.com/watch?v=UD9XHqziQFs
 */
public class _0200_Number_of_Islands {

    // BFS
    class Solution {
        public int numIslands(char[][] grid) {
            int island = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        island++;
                        bfs(grid, i, j);
                    }
                }
            }

            return island;
        }

        private void bfs(char[][] grid, int x, int y) {
            int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Queue<int[]> q = new LinkedList();
            q.add(new int[]{x, y});
            grid[x][y] = '0';

            while (q.size() > 0) {
                int[] curr = q.poll();
                for (int[] d : dir) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
                        continue;
                    grid[r][c] = '0';
                    q.add(new int[]{r, c});
                }
            }
        }
    }

    // DFS
    class Solution2 {
        public int numIslands2(char[][] grid) {
            int island = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        island++;
                        dfs(grid, i, j);
                    }
                }
            }

            return island;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
                return;
            grid[x][y] = '0';
            dfs(grid, x + 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x - 1, y);
            dfs(grid, x, y - 1);
        }
    }
}
