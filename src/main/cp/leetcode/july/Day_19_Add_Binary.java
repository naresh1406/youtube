package main.cp.leetcode.july;

import java.math.BigInteger;

/**
 * Day_19_Add_Binary
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
 */
public class Day_19_Add_Binary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;

            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) sum += a.charAt(i--) - '0';
                if (j >= 0) sum += b.charAt(j--) - '0';
                sb.append(sum % 2);
                carry = sum / 2;
            }

            if (carry != 0) sb.append(carry);

            return sb.reverse().toString();
        }
    }

    class Solution2 {
        public String addBinary(String a, String b) {
            return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
        }
    }
}