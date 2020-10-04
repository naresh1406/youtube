package main.cp.leetcode.october;

import java.util.Arrays;

public class Day_04_1288_Remove_Covered_Intervals {
    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] currInt = {-1, -1};
            int result = 0;
            for (int[] interval : intervals) {
                if (currInt[0] < interval[0] && currInt[1] < interval[1]) {
                    currInt[0] = interval[0];
                    result++;
                }
                currInt[1] = Math.max(currInt[1], interval[1]);
            }

            return result;
        }
    }

    class Solution2 {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] currInt = {-1, -1};
            int overlap = 0;
            for (int[] interval : intervals) {
                if (currInt[0] <= interval[0] && currInt[1] >= interval[1]) {
                    overlap++;
                } else {
                    if (currInt[0] >= interval[0] && currInt[1] <= interval[1])
                        overlap++;
                    currInt = interval;
                }
            }

            return intervals.length - overlap;
        }
    }
}
