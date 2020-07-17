package main.cp.leetcode.july;

/**
 * Day_12_Reverse_Bits
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
 */
public class Day_12_Reverse_Bits {
    // 1. Bitwise Operators
    class Solution {
        public int reverseBits(int n) {
            int reverse = 0;
            for (int i = 0; i < 32; i++) {
                reverse = (reverse << 1) | (n & 1);
                n >>= 1;
            }
            return reverse;
        }
    }

    // 2. 1-Liner using Integer.reverse()
    class Solution2 {
        public int reverseBits(int n) {
            return Integer.reverse(n);
        }
    }
}
