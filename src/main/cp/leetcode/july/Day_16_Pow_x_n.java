package main.cp.leetcode.july;

/**
 * Day_16_Pow_x_n
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
 */
public class Day_16_Pow_x_n {

    // 1. Recursive
    class Solution {
        public double myPow(double x, int n) {
            return myPow(x, 1L * n);
        }

        private double myPow(double x, long n) {
            if (n == 0)
                return 1;
            if (n < 0)
                return myPow(1 / x, -n);
            return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }

    // 2. Iterative
    class Solution2 {
        public double myPow(double x, int n) {
            long l = Math.abs((long) n);
            double ans = 1;
            while (l > 0) {
                if ((l & 1) == 1)
                    ans *= x;
                x *= x;
                l >>= 1;
            }
            return n < 0 ? 1 / ans : ans;
        }
    }
}
