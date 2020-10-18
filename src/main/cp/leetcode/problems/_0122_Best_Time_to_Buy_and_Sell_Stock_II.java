package main.cp.leetcode.problems;

public class _0122_Best_Time_to_Buy_and_Sell_Stock_II {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            return maxProfit;
        }
    }
}
