package main.cp.leetcode.problems;

public class _1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int res = 0;
            for (int l : left)
                res = Math.max(l, res);
            for (int r : right)
                res = Math.max(n - r, res);
            return res;
        }
    }
}
