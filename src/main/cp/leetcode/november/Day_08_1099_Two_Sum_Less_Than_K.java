package main.cp.leetcode.november;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 8/11/2020 AD.
 */
public class Day_08_1099_Two_Sum_Less_Than_K {
    /**
     * Suppose we have an array A of integers and another integer K is given.
     * We have to find the maximum S such that there exists i < j with A[i] + A[j] = S and S < K.
     * If there is no i, j exists satisfying this equation, then return -1.
     * So for example if A = [34,23,1,24,75,33,54,8] and K = 60, then the output will be 58,
     * as we can use 34 and 24 to sum 58, which is less than 60.
     */

    static class Solution {
        public static void main(String[] args) {
            Solution obj = new Solution();
            System.out.println(obj.twoSumLessThanK(new int[]{5, 20, 110, 100, 10}, 100));
            System.out.println(obj.twoSumLessThanK(new int[]{5, 20, 110, 100, 10}, 109));
            System.out.println(obj.twoSumLessThanK(new int[]{5, 20, 110, 100, 10}, 25));
        }

        // O(nLogn)
        public int twoSumLessThanK(int[] A, int K) {
            Arrays.sort(A);
            int i = 0, j = A.length - 1;
            int S = 0;
            while (i < j) {
                if (A[i] + A[j] >= K) {
                    j--;
                } else {
                    S = Math.max(S, A[i] + A[j]);
                    i++;
                }
            }
            return S;
        }

        // O(n^2)
        public int twoSumLessThanK2(int[] A, int K) {
            int S = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] + A[j] < K && A[i] + A[j] > S)
                        S = A[i] + A[j];
                }
            }
            return S;
        }
    }
}




