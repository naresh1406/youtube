package main.cp.leetcode.july;

/**
 * Day 06 Plus One
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
 */
public class Day_06_Plus_One {
    // 1. Iterative
    class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for(int i = n - 1; i >= 0; i--) {
                if(digits[i] != 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }

            // [9,9,9]
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }
    }

    // 2. Recursive
    class Solution2 {
        public int[] plusOne(int[] digits) {
            return plusOne(digits, digits.length - 1);
        }

        //[8, 9]
        private int[] plusOne(int[] digits, int index) {
            if(digits[index] != 9) {
                digits[index]++;
                return digits;
            } else if(index != 0) {
                digits[index] = 0;
                return plusOne(digits, index - 1);
            } else {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }
        }
    }
}
