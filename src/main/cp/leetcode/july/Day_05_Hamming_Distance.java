package main.cp.leetcode.july;

/**
 * Day 05 Hamming Distance
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
 */
public class Day_05_Hamming_Distance {
    // 1. XOR 1 Liner using Integer.bitCount
    class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

    // 2. XOR with custom bitCount
    class Solution2 {
        public int hammingDistance(int x, int y) {
            return bitCount(x ^ y);
        }

        private int bitCount(int n) {
            int count = 0;
            while (n > 0) {
                if (n % 2 == 1)
                    count++;
                n /= 2;
            }

            return count;
        }
    }

    // 3. XOR with custom bitCount using bitwise &
    class Solution3 {
        public int hammingDistance(int x, int y) {
            return bitCount(x ^ y);
        }

        private int bitCount(int n) {
            int count = 0;
            while (n > 0) {
                n &= (n - 1);
                count++;
            }

            return count;
        }
    }

    // 4. WithoutXOR
    class Solution4 {
        // TC - O(32) ~ O(1)
        public int hammingDistance(int x, int y) {
            int hd = 0;
            while (x > 0 || y > 0) {
                hd += x % 2 != y % 2 ? 1 : 0;
                x /= 2;
                y /= 2;
            }
            return hd;
        }
    }
}
