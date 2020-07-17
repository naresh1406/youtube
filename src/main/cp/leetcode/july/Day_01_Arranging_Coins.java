package main.cp.leetcode.july;

/**
 * Day 01 Arranging Coins
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
 */
public class Day_01_Arranging_Coins {
    // Brute Froce
    class Solution {
        public int arrangeCoins(int n) {
            int k = 0;
            while(n > 0){
                k++;
                n -= k;
            }
            return n == 0 ? k : k - 1;
        }
    }

    // Binary Search
    class Solution2 {
        public int arrangeCoins(int n) {
            long start = 0, end = n;
            long k, curr;
            while(start <= end) {
                k = start + (end - start) / 2;
                curr = k * (k + 1) / 2;
                if(curr == n) return (int) k;
                if(n < curr) end = k - 1;
                else start = k + 1;
            }
            return (int)end;
        }
    }

    // Math
    class Solution3 {
        public int arrangeCoins(int n) {
            return (int)(Math.sqrt((8L * n + 1)) - 1)/2;
        }
    }
}
