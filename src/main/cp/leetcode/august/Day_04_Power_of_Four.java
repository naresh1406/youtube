package main.cp.leetcode.august;

public class Day_04_Power_of_Four {
    // 1. while loop
    class Solution {
        public boolean isPowerOfFour(int num) {
            if (num > 1)
                while (num % 4 == 0)
                    num /= 4;
            return num == 1;
        }
    }

    // 2.
    class Solution2 {
        public boolean isPowerOfFour(int num) {
            return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
        }
    }

    // 3. Log and Power
    class Solution3 {
        public boolean isPowerOfFour(int num) {
            return num > 0 && num == Math.pow(4, (int) logn(num, 4)); // return num > 0 && (int)logn(num, 4) == logn(num, 4);
        }

        private double logn(int n, int r) {
            return Math.log(n) / Math.log(r);
        }
    }

    // 4.
    class Solution4 {
        public boolean isPowerOfFour(int num) {
            return num == 1 ? true : num > 0 && (num & (num - 1)) == 0 && (num % 10 == 4 || num % 10 == 6);
            // return num > 0 && (num & (num - 1)) == 0 && (num % 10 == 1 || num % 10 == 4 || num % 10 == 6);
        }
    }
}
