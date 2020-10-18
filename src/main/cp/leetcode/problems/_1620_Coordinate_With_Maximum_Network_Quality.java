package main.cp.leetcode.problems;

import java.util.PriorityQueue;

public class _1620_Coordinate_With_Maximum_Network_Quality {

    // Contest AC with Assumption
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : b[0] - a[0]);
            int maxSQ = 0, mx = 0, my = 0;
            for (int x = 0; x < 51; x++) {
                for (int y = 0; y < 51; y++) {
                    int quality = 0;
                    for (int j = 0; j < towers.length; j++) {
                        // if (i == j) continue;
                        int xd = x - towers[j][0];
                        int yd = y - towers[j][1];
                        double d = Math.sqrt(xd * xd + yd * yd);
                        if (d <= (double) radius) {
                            quality += (int) (towers[j][2] / (1 + d));
                        }
                    }
                    if (quality > maxSQ) {
                        maxSQ = quality;
                        mx = x;
                        my = y;
                    }
                }
            }

            return new int[]{mx, my};
        }
    }


    // Contest AC with Assumption
    class Solution2 {
        public int[] bestCoordinate(int[][] towers, int radius) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : b[0] - a[0]);
            for (int i = 0; i < towers.length; i++) {
                int quality = 0;
                for (int j = 0; j < towers.length; j++) {
                    // if (i == j) continue;
                    int x = towers[i][0] - towers[j][0];
                    int y = towers[i][1] - towers[j][1];
                    double d = Math.sqrt(x * x + y * y);
                    if (d <= (double) radius) {
                        quality += (int) (towers[j][2] / (1 + d));
                    }
                }
                pq.add(new int[]{quality, towers[i][0], towers[i][1]});
            }

            return new int[]{pq.peek()[1], pq.peek()[2]};
        }
    }
}
