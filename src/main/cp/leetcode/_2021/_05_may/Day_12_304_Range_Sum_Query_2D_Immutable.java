package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 12/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=BS3PJLi4BYU
 */
public class Day_12_304_Range_Sum_Query_2D_Immutable {
    class NumMatrix_Naive {

        int[][] matrix;

        public NumMatrix_Naive(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++)
                for (int j = col1; j <= col2; j++)
                    sum += matrix[i][j];

            return sum;
        }
    }


    class NumMatrix_Optimal {

        private int[][] sum;

        public NumMatrix_Optimal(int[][] matrix) {
            if (matrix.length == 0)
                return;

            int m = matrix.length, n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        }
    }
}
