package main.cp.leetcode.november;

/**
 * Created by Naresh Gupta on 26/11/2020 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=ZDUYcl4cB1s
 */
public class Day_25_1015_Smallest_Integer_Divisible_by_K {
    class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0)
                return -1;
            int N = 1;
            int len = 1;

            while (N % K != 0) {
                N = (N * 10 + 1) % K;
                len++;
            }

            return len;
        }
    }
}
