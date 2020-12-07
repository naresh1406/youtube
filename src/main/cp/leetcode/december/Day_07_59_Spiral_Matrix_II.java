package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 8/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/vAIp15jqQbU?t=0
 */
public class Day_07_59_Spiral_Matrix_II {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int top = 0, bottom = n - 1, left = 0, right = n - 1;
            int val = 1;
            while (val <= n * n) {
                for (int i = left; i <= right; i++)
                    matrix[top][i] = val++; // fill top row
                top++;

                for (int i = top; i <= bottom; i++)
                    matrix[i][right] = val++; // fill right column
                right--;

                for (int i = right; i >= left; i--)
                    matrix[bottom][i] = val++; // fill bottom raw
                bottom--;

                for (int i = bottom; i >= top; i--)
                    matrix[i][left] = val++; // fill right column
                left++;
            }

            return matrix;
        }
    }
}
