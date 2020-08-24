package main.cp.leetcode.problems;

import java.util.Arrays;

public class _1561_Maximum_Number_of_Coins_You_Can_Get {
    // 1. With For Loop
    class Solution {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int coins = 0;
            for (int j = 0, i = piles.length - 2; j < piles.length / 3; j++, i -= 2)
                coins += piles[i];
            return coins;
        }
    }

    // 2. With While Loop
    class Solution2 {
        public int maxCoins(int[] piles) {
            Arrays.sort(piles);
            int coins = 0;
            int i = piles.length - 2;
            int j = 0;
            while (j++ < piles.length / 3) {
                coins += piles[i];
                i -= 2;
            }
            return coins;
        }
    }
}
