package main.cp.leetcode.august;

import java.util.Arrays;

public class Day_15_Non_overlapping_Intervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;

            Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

            int minErase = 0;
            int prevEnd = Integer.MIN_VALUE;

            for (int[] interval : intervals) {
                if (prevEnd > interval[0]) minErase++;
                else prevEnd = interval[1];
            }

            return minErase;
        }
    }
}
