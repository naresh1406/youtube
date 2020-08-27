package main.cp.leetcode.august;

import java.util.TreeMap;

public class Day_27_Find_Right_Interval {
    // 1. TreeMap / Binary Search
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            if (n == 1)
                return new int[]{-1};

            TreeMap<Integer, Integer> map = new TreeMap();
            for (int i = 0; i < n; i++) {
                map.put(intervals[i][0], i);
            }

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                Integer key = map.ceilingKey(intervals[i][1]);
                result[i] = key == null ? -1 : map.get(key);
            }

            return result;
        }
    }

    // Brute Force
    class Solution2 {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            if (n == 1)
                return new int[]{-1};

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = getIndex(intervals, intervals[i][1]);
            }

            return result;
        }

        private int getIndex(int[][] intervals, int key) {
            for (int i = 0; i < intervals.length; i++) {
                if (key == intervals[i][0])
                    return i;
            }
            for (int i = 0; i < intervals.length; i++) {
                if (key < intervals[i][0])
                    return i;
            }
            return -1;
        }
    }
}
