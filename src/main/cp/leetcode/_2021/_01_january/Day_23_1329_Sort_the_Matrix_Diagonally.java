package main.cp.leetcode._2021._01_january;

import java.util.*;

/**
 * Created by Naresh Gupta on 27/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=-JA2x0yAxd4
 */
public class Day_23_1329_Sort_the_Matrix_Diagonally {
    // Solution 1: Same diagonal have same value of i - j
    // TC - O(mnlog(d)) -> m - num of row, n - num of col, d - avg length of diagonal
    // SC - O(mn)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap();
            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[0].length; j++)
                    map.computeIfAbsent(i - j, p -> new PriorityQueue()).add(mat[i][j]);

            for (int i = 0; i < mat.length; i++)
                for (int j = 0; j < mat[0].length; j++)
                    mat[i][j] = map.get(i - j).poll();

            return mat;
        }
    }

    class Solution2 {
        public int[][] diagonalSort(int[][] mat) {
            for (int i = 0; i < mat.length; i++)
                diagonalSort(mat, i, 0); // all diagonals start from first row

            for (int i = 0; i < mat[0].length; i++)
                diagonalSort(mat, 0, i); // all diagonals start from first column

            return mat;
        }

        private void diagonalSort(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            List<Integer> list = new ArrayList<>();
            for (int i = r, j = c; i < m && j < n; i++, j++)
                list.add(mat[i][j]);

            Collections.sort(list);

            for (int num : list)
                mat[r++][c++] = num;
        }
    }

    class Solution3 {
        public int[][] diagonalSort(int[][] mat) {
            for (int i = 0; i < mat.length; i++)
                diagonalSort(mat, i, 0); // all diagonals start from first row

            for (int i = 0; i < mat[0].length; i++)
                diagonalSort(mat, 0, i); // all diagonals start from first column

            return mat;
        }

        private void diagonalSort(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = r, j = c; i < m && j < n; i++, j++)
                pq.add(mat[i][j]);

            while (pq.size() > 0)
                mat[r++][c++] = pq.poll();
        }
    }
}
