package main.cp.leetcode._2021._01_january;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 28/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=pHfGapkUEw0
 */
public class Day_26_1631_Path_With_Minimum_Effort {
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int l = 0, r = 1000001;
            while (l < r) {
                int m = (l + r) / 2;
                if (good(heights, m)) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        private boolean good(int[][] h, int limit) {
            int R = h.length;
            int C = h[0].length;
            Queue<int[]> q = new LinkedList();
            boolean[][] visited = new boolean[R][C];
            visited[0][0] = true;
            q.add(new int[]{0, 0});

            while (q.size() > 0) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();
                if (x == R - 1 && y == C - 1)
                    return true;
                int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                        if (Math.abs(h[x][y] - h[nx][ny]) <= limit) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            return false;
        }
    }

    // Dijkstra
    class Solution2 {
        public int minimumEffortPath(int[][] h) {
            int R = h.length;
            int C = h[0].length;
            Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            boolean[][] visited = new boolean[R][C];
            q.add(new int[]{0, 0, 0});
            int[][] cost = new int[R][C];
            for (int i = 0; i < R; i++)
                Arrays.fill(cost[i], Integer.MAX_VALUE);

            cost[0][0] = 0;

            while (q.size() > 0) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                int w = q.peek()[2];
                q.poll();
                visited[x][y] = true;
                int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                        int maxCost = Math.max(Math.abs(h[x][y] - h[nx][ny]), cost[x][y]);
                        if (maxCost < cost[nx][ny]) {
                            cost[nx][ny] = maxCost;
                            q.add(new int[]{nx, ny, cost[nx][ny]});
                        }
                    }
                }
            }

            return cost[R - 1][C - 1];
        }
    }
}
