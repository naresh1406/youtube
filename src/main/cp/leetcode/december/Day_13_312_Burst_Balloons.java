package main.cp.leetcode.december;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 14/12/2020 AD.
 */
public class Day_13_312_Burst_Balloons {
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] A = new int[n];
            A[0] = A[n - 1] = 1;
            for (int i = 0; i < nums.length; i++)
                A[i + 1] = nums[i];

            return getCoin(A, 0, n - 1);
        }

        Map<String, Integer> map = new HashMap();

        private int getCoin(int[] A, int l, int r) {
            String key = l + "|" + r;
            if (!map.containsKey(key)) {
                int max_coin = 0;
                for (int i = l + 1; i < r; i++) {
                    int score = A[l] * A[i] * A[r];
                    max_coin = Math.max(max_coin, score + getCoin(A, l, i) + getCoin(A, i, r));
                }
                map.put(key, max_coin);
            }

            return map.get(key);
        }
    }
}
