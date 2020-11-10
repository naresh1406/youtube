package main.cp.leetcode.november;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 10/11/2020 AD.
 */
public class Day_10_832_Flipping_an_Image {
    class Solution {
        // TC - O(mn)
        // SC - O(1);
        public int[][] flipAndInvertImage(int[][] A) {
            for(int[] row : A) {
                int l = 0, r = row.length - 1;
                while(l <= r) {
                    int temp = row[l];
                    row[l++] = row[r] ^ 1;
                    row[r--] = temp ^ 1;
                }
            }

            return A;
        }
    }
}
