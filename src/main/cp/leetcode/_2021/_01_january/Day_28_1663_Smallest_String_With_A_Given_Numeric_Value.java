package main.cp.leetcode._2021._01_january;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 28/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/zz-NbpEERDU?t=0
 */
public class Day_28_1663_Smallest_String_With_A_Given_Numeric_Value {
    // TC - O(n)

    class Solution {
        public String getSmallestString(int n, int k) {
            char[] result = new char[n];
            Arrays.fill(result, 'a');
            k -= n;
            while (k > 0) {
                result[--n] += Math.min(25, k);
                k -= Math.min(25, k);
            }
            return String.valueOf(result);
        }
    }
}
