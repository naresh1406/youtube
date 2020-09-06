package main.cp.leetcode.problems;

public class _1572_Matrix_Diagonal_Sum {
    class Solution {
        public int diagonalSum(int[][] mat) {
            int n = mat.length;
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += mat[i][i] + mat[i][n - 1 - i];
            return n % 2 == 1 ? sum - mat[n / 2][n / 2] : sum;
        }
    }
}
