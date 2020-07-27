package main.cp.leetcode.july;

/**
 * Day_26_Add_Digits
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3402/
 */
public class Day_26_Add_Digits {
    // 1. Using Loop
    class Solution {
        public int addDigits(int num) {
            int digitSum = 0;
            while(num > 0) {
                digitSum += num % 10;
                num /= 10;
                if(num == 0 && digitSum > 9) {
                    num = digitSum;
                    digitSum = 0;
                }
            }
            return digitSum;
        }
    }

    // 2. Using formula
    class Solution2 {
        public int addDigits(int num) {
            return 1 + (num - 1) % 9;
        }
    }
}
