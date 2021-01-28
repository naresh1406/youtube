package main.cp.leetcode._2021._01_january;

import java.util.stream.LongStream;

/**
 * Created by Naresh Gupta on 28/1/2021 AD.
 */
public class Day_27_1680_Concatenation_of_Consecutive_Binary_Numbers {
    // TC - O(nLogn)

    class Solution {
        public int concatenatedBinary(int n) {
            int MOD = 1_000_000_007;
            long sum = 0;
            for (int i = 1; i <= n; i++)
                sum = (sum * (int) Math.pow(2, Integer.toBinaryString(i).length()) + i) % MOD; // sum = ((sum << Integer.toBinaryString(i).length()) + i) % MOD;

            return (int) sum;
        }
    }

    // Bitwise
    // TC - O(n)

    class Solution2 {
        public int concatenatedBinary(int n) {
            int MOD = 1_000_000_007;
            long sum = 0;
            int length = 0;

            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0)
                    length++;
                sum = ((sum << length) | i) % MOD;
            }

            return (int) sum;
        }
    }

    // Java-8: 1 Liner using Long.range and reduce
    // TC - O(nLogn)

    class Solution3 {
        public int concatenatedBinary(int n) {
            return (int) LongStream.range(1, n + 1).reduce(0, (sum, i) -> (sum * (int) Math.pow(2, Long.toBinaryString(i).length()) + i) % 1_000_000_007);
        }
    }
}
