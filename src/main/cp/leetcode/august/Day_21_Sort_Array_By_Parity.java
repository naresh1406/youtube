package main.cp.leetcode.august;

import java.util.Arrays;

public class Day_21_Sort_Array_By_Parity {
    // 1. Two Pointer
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int i = 0, j = A.length - 1;
            while (i < j) {
                if (A[i] % 2 == 0) i++;
                else if (A[j] % 2 == 1) j--;
                else swap(A, i++, j--);
            }
            return A;
        }

        private void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    // 2. 1-liner using stream
    class Solution2 {
        public int[] sortArrayByParity(int[] A) {
            return Arrays.stream(A)
                    .boxed()
                    .sorted((a, b) -> Integer.compare(a % 2, b % 2))
                    .mapToInt(i -> i)
                    .toArray();
        }
    }
}
