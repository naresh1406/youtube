package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 30/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=X-kwLgPQO4g
 */
public class _0007_Reverse_Integer {
    class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int digit = x % 10;
                x /= 10;

                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                    return 0;

                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10))
                    return 0;

                rev = rev * 10 + digit;
            }

            return rev;
        }
    }
}