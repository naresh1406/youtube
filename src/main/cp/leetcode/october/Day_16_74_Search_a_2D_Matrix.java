package main.cp.leetcode.october;

public class Day_16_74_Search_a_2D_Matrix {
    // O(log(mn)) Time

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int start = 0, end = m * n - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (matrix[mid / n][mid % n] == target) return true;
                else if (matrix[mid / n][mid % n] < target) start = mid + 1;
                else end = mid - 1;
            }
            return false;
        }
    }

    // O(m +n) Time

    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int r = 0, c = n - 1;
            while (c >= 0 && r < m) {
                if (matrix[r][c] == target) return true;
                else if (matrix[r][c] > target) c--;
                else r++;
            }
            return false;
        }
    }

    // O(mn) Time

    class Solution3 {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    if (matrix[i][j] == target)
                        return true;
            return false;
        }
    }
}
