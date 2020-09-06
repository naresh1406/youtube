package main.cp.leetcode.problems;

public class _1573_Number_Of_Ways_To_Split_A_String {
    class Solution {
        public int numWays(String s) {
            long ones = 0;
            long n = s.length();
            long MOD = 1_000_000_007;
            for (char c : s.toCharArray())
                ones += c - '0';
            if (ones == 0)
                return (int) ((((n - 1) * (n - 2)) / 2) % MOD);
            if (ones % 3 != 0)
                return 0;
            long oneThird = ones / 3;
            ones = 0;
            long ways1 = 0;
            long ways2 = 0;
            for (char c : s.toCharArray()) {
                ones += c - '0';
                if (ones == oneThird) ways1++;
                if (ones == 2 * oneThird) ways2++;
            }
            return (int) ((ways1 * ways2) % MOD);
        }
    }
}
