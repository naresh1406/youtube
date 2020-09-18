package main.cp.leetcode.september;

public class Day_18_Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            return helper(prices, 0, Integer.MAX_VALUE, 0);
        }

        private int helper(int[] prices, int i, int minStockPrice, int maxProfit) {
            if (i == prices.length)
                return maxProfit;
            maxProfit = Math.max(maxProfit, prices[i] - minStockPrice);
            minStockPrice = Math.min(minStockPrice, prices[i]);
            return helper(prices, i + 1, minStockPrice, maxProfit);
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            int maxProfit = 0, minStockPrice = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                maxProfit = Math.max(maxProfit, prices[i] - minStockPrice);
                minStockPrice = Math.min(minStockPrice, prices[i]);
            }
            return maxProfit;
        }
    }
}
