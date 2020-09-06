package main.cp.leetcode.problems;

public class _1578_Minimum_Deletion_Cost_To_Avoid_Repeating_Letters {
    class Solution {
        public int minCost(String s, int[] cost) {
            int n = s.length(), gsum = 0, gmax = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                    ans += gsum - gmax;
                    gsum = 0;
                    gmax = 0;
                }
                gsum += cost[i];
                gmax = Math.max(gmax, cost[i]);
            }

            ans += gsum - gmax;
            return ans;
        }
    }
}
