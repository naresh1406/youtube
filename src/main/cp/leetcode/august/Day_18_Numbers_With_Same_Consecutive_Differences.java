package main.cp.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Day_18_Numbers_With_Same_Consecutive_Differences {
    class Solution {
        public int[] numsSameConsecDiff(int N, int K) {
            if (N == 1)
                return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> result = new ArrayList<Integer>();
            for (int num = 1; num < 10; ++num)
                dfs(N - 1, num, K, result);

            return result.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(int N, int num, int K, List<Integer> result) {
            if (N == 0) {
                result.add(num);
                return;
            }

            if (num % 10 + K < 10)
                dfs(N - 1, num * 10 + num % 10 + K, K, result);

            if (K > 0 && num % 10 - K >= 0)
                dfs(N - 1, num * 10 + num % 10 - K, K, result);
        }
    }
}

