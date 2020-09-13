package main.cp.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_Merge_Intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> result = new ArrayList();
            if (intervals.length <= 1)
                return intervals;
            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
            int[] in = intervals[0];
            int i = 1;
            while (i < intervals.length) {
                if (in[1] < intervals[i][0]) {
                    result.add(in);
                    in = intervals[i];
                } else {
                    in[1] = Math.max(in[1], intervals[i][1]);
                }
                i++;
            }
            result.add(in);

            return result.toArray(new int[result.size()][]);
        }
    }
}
