package main.cp.leetcode.september;

public class Day_06_Image_Overlap {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            int largestOverlap = 0;
            for (int row = -A.length + 1; row < A.length; row++)
                for (int col = -A.length + 1; col < A.length; col++)
                    largestOverlap = Math.max(largestOverlap, overlapOnes(A, B, row, col));
            return largestOverlap;
        }

        private int overlapOnes(int[][] A, int[][] B, int rowOff, int colOff) {
            int count = 0;
            for (int row = 0; row < A.length; row++) {
                for (int col = 0; col < A[0].length; col++) {
                    if ((row + rowOff < 0 || row + rowOff >= A.length) || (col + colOff < 0 || col + colOff >= A[0].length))
                        continue;
                    if (A[row][col] + B[row + rowOff][col + colOff] == 2)
                        count++;
                }
            }

            return count;
        }
    }
}
