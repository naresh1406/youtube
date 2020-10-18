package main.cp.leetcode.october;

import java.util.Arrays;

public class Day_18_188_Best_Time_to_Buy_and_Sell_Stock_IV {
    // Recursive - TLE
    class Solution {
        public int maxProfit(int k, int[] prices) {
            return helper(prices, 0, 1, 0, k);
        }

        private int helper(int[] prices, int i, int buy, int tx, int k) {
            if (i >= prices.length || tx >= k)
                return 0;
            if (buy == 1)
                return Math.max(-prices[i] + helper(prices, i + 1, 0, tx, k), helper(prices, i + 1, buy, tx, k));
            else
                return Math.max(prices[i] + helper(prices, i + 1, 1, tx + 1, k), helper(prices, i + 1, buy, tx, k));
        }
    }

    // Top Down DP
    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if (k >= prices.length) {
                int maxProfit = 0;
                for (int i = 1; i < prices.length; i++)
                    if (prices[i] > prices[i - 1])
                        maxProfit += prices[i] - prices[i - 1];
                return maxProfit;
            }
            int[] buy = new int[k + 1], sell = new int[k + 1];
            Arrays.fill(buy, Integer.MIN_VALUE);
            for (int price : prices) {
                for (int i = 1; i <= k; i++) {
                    buy[i] = Math.max(buy[i], sell[i - 1] - price);
                    sell[i] = Math.max(sell[i], buy[i] + price);
                }
            }
            return sell[k];
        }
    }

    // Bottom Up with Buy and Sell Cache separate
    class Solution3 {
        public int maxProfit(int k, int[] prices) {
            k = k > prices.length / 2 ? prices.length / 2 : k; // Case of Problem 122. Best Time to Buy and Sell Stock II
            int[] buy = new int[k + 1], sell = new int[k + 1];
            Arrays.fill(buy, Integer.MIN_VALUE);
            for (int price : prices) {
                for (int i = 1; i <= k; i++) {
                    buy[i] = Math.max(buy[i], sell[i - 1] - price);
                    sell[i] = Math.max(sell[i], buy[i] + price);
                }
            }
            return sell[k];
        }
    }
}
