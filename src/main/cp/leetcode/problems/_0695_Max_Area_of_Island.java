package main.cp.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 2/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=LrbsISJVVGg
 */
public class _0695_Max_Area_of_Island {
    class Solution {
        // TC - O(m * n)
        public int maxAreaOfIsland(int[][] grid) {
            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        area = Math.max(area, bfs(grid, i, j));
                    }
                }
            }

            return area;
        }

        private int bfs(int[][] grid, int x, int y) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Queue<int[]> q = new LinkedList();
            q.offer(new int[]{x, y});
            grid[x][y] = -1;
            int count = 0;
            while (q.size() > 0) {
                int[] xy = q.poll();
                count++;
                for (int[] d : dir) {
                    int nx = xy[0] + d[0];
                    int ny = xy[1] + d[1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny});
                        grid[nx][ny] = -1;
                    }
                }
            }

            return count;
        }

        private int dfs(int[][] grid, int x, int y) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
                return 0;
            grid[x][y] = -1;
            return 1 + dfs(grid, x + 1, y) + dfs(grid, x, y + 1) + dfs(grid, x - 1, y) + dfs(grid, x, y - 1);
        }
    }
}
