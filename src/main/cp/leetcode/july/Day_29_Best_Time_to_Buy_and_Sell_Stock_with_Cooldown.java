package main.cp.leetcode.july;

import java.util.HashMap;
import java.util.Map;

/**
 * Day_29_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
 */
public class Day_29_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    class Solution {
        // TC - O(N)
        int N;

        public int maxProfit(int[] prices) {
            N = prices.length;
            return buy(prices, 0);
        }

        Map<Integer, Integer> buyMap = new HashMap();

        private int buy(int[] prices, int i) {
            if (i >= N) return 0;
            if (buyMap.containsKey(i))
                return buyMap.get(i);
            buyMap.put(i, Math.max(-prices[i] + sell(prices, i + 1), buy(prices, i + 1)));
            return buyMap.get(i);
        }

        Map<Integer, Integer> sellMap = new HashMap();

        private int sell(int[] prices, int i) {
            if (i >= N) return 0;
            if (sellMap.containsKey(i))
                return sellMap.get(i);
            sellMap.put(i, Math.max(prices[i] + buy(prices, i + 2), sell(prices, i + 1)));
            return sellMap.get(i);
        }
    }
}
