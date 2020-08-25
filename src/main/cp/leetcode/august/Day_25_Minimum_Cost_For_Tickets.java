package main.cp.leetcode.august;

public class Day_25_Minimum_Cost_For_Tickets {
    // 1. Recursive
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            return helper(days, costs, 0);
        }

        private int helper(int[] days, int[] costs, int day) {
            if(day >= days.length)
                return 0;

            int ondDayPass = helper(days, costs, day + 1) + costs[0]; // for 1 day pass

            int i;
            for(i = day; i < days.length; i++)
                if(days[i] >= days[day] + 7)
                    break;

            int sevenDayPass = helper(days, costs, i) + costs[1]; // for 7 day pass

            for(i = day; i < days.length; i++)
                if(days[i] >= days[day] + 30)
                    break;

            int thirtyDayPass = helper(days, costs, i) + costs[2]; // for 30 day pass

            return Math.min(ondDayPass, Math.min(sevenDayPass, thirtyDayPass));
        }
    }

    // 2. Top Down DP
    class Solution2 {
        Integer[] dp;
        public int mincostTickets(int[] days, int[] costs) {
            dp = new Integer[days.length];
            return helper(days, costs, 0);
        }

        private int helper(int[] days, int[] costs, int day) {
            if(day >= days.length)
                return 0;

            if(dp[day] != null)
                return dp[day];

            int ondDayPass = helper(days, costs, day + 1) + costs[0];

            int i;
            for(i = day; i < days.length; i++)
                if(days[i] >= days[day] + 7)
                    break;

            int sevenDayPass = helper(days, costs, i) + costs[1];

            for(i = day; i < days.length; i++)
                if(days[i] >= days[day] + 30)
                    break;

            int thirtyDayPass = helper(days, costs, i) + costs[2];

            return dp[day] = Math.min(ondDayPass, Math.min(sevenDayPass, thirtyDayPass));
        }
    }
}
