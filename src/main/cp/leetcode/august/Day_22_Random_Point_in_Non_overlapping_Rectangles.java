package main.cp.leetcode.august;

import java.util.Random;
import java.util.TreeMap;

public class Day_22_Random_Point_in_Non_overlapping_Rectangles {
    class Solution {

        private int[][] rects;
        private Random random;
        private TreeMap<Integer, Integer> map;
        private int sum;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            map = new TreeMap();
            sum = 0;

            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                map.put(sum, i);
            }
        }

        public int[] pick() {
            int num = map.ceilingKey(random.nextInt(sum) + 1);
            int[] xy = rects[map.get(num)];
            return new int[]{xy[0] + random.nextInt(xy[2] - xy[0] + 1), xy[1] + random.nextInt(xy[3] - xy[1] + 1)};
        }
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
}
