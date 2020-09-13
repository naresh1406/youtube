package main.cp.leetcode.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day_13_Insert_Interval {
    // 1. TC - O(n)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList();
            for (int[] in : intervals) {
                if (in[1] < newInterval[0]) {
                    list.add(in);
                } else if (newInterval[1] < in[0]) {
                    list.add(newInterval);
                    newInterval = in;
                } else {
                    newInterval[0] = Math.min(newInterval[0], in[0]);
                    newInterval[1] = Math.max(newInterval[1], in[1]);
                }
            }
            list.add(newInterval);

            return list.toArray(new int[list.size()][]);
        }
    }

    // 2. Merge Interval Approach, TC - O(nlogn)
    class Solution2 {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int[][] in = new int[intervals.length + 1][2];
            for (int i = 0; i < intervals.length; i++)
                in[i] = intervals[i];
            in[intervals.length] = newInterval;
            return merge(in);
        }

        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0)
                return intervals;

            List<int[]> list = new ArrayList();
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] in = intervals[0];
            int i = 1;
            while (i < intervals.length) {
                if (intervals[i][0] > in[1]) {
                    list.add(in);
                    in = intervals[i];
                } else {
                    in[1] = Math.max(intervals[i][1], in[1]);
                }
                i++;
            }
            list.add(in);

            return list.toArray(new int[list.size()][]);
        }
    }
}
