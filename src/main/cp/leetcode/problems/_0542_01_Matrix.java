package main.cp.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 29/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=RySXom_lslY
 */
public class _0542_01_Matrix {
    // TC - O((m x n) ^ 2)
    class Solution_1 {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int[][] result = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] > 0) {
                        result[i][j] = dfs(mat, i, j, new boolean[m][n]);
                    }
                }
            }

            return result;
        }

        private int dfs(int[][] mat, int x, int y, boolean[][] visited) {
            if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || visited[x][y])
                return 100000;
            if (mat[x][y] == 0)
                return 0;
            visited[x][y] = true;
            int val = 1 + Math.min(
                    Math.min(dfs(mat, x + 1, y, visited), dfs(mat, x - 1, y, visited)),
                    Math.min(dfs(mat, x, y + 1, visited), dfs(mat, x, y - 1, visited))
            );

            visited[x][y] = false;

            return val;
        }
    }

    // TC - O(m x n)
    class Solution_2 {
        public int[][] updateMatrix(int[][] A) {
            int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Queue<int[]> q = new LinkedList<>();

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 0) {
                        q.offer(new int[]{i, j});
                    }
                }
            }

            int level = 0;
            while (q.size() > 0) {
                level++;
                for (int i = q.size(); i > 0; i--) {
                    int[] xy = q.poll();
                    for (int[] d : dir) {
                        int nx = xy[0] + d[0];
                        int ny = xy[1] + d[1];
                        if (nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && A[nx][ny] == 1) {
                            A[nx][ny] = -level;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] *= -1;
                }
            }

            return A;
        }
    }

    // TC - O(m x n)
    class Solution_3 {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            int MAX = 1000000;

            // top to bottom and left to right
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] != 0) {
                        int top = i - 1 >= 0 ? mat[i - 1][j] : MAX;
                        int left = j - 1 >= 0 ? mat[i][j - 1] : MAX;
                        mat[i][j] = Math.min(top, left) + 1;
                    }
                }
            }

            // bottom to top and right to left
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] != 0) {
                        int bottom = i + 1 < m ? mat[i + 1][j] : MAX;
                        int right = j + 1 < n ? mat[i][j + 1] : MAX;
                        mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
                    }
                }
            }

            return mat;
        }
    }
}
