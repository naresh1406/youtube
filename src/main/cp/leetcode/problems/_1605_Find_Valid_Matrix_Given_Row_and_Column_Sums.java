package main.cp.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class _1605_Find_Valid_Matrix_Given_Row_and_Column_Sums {
    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int m = rowSum.length;
            int n = colSum.length;
            int[][] mat = new int[m][n];

            Set<Integer> rSet = new HashSet();
            Set<Integer> cSet = new HashSet();

            while (rSet.size() != m && cSet.size() != n) {
                int ri = minInd(rowSum, rSet);
                int ci = minInd(colSum, cSet);
                if (rowSum[ri] < colSum[ci]) {
                    mat[ri][ci] = rowSum[ri];
                    colSum[ci] -= rowSum[ri];
                    rSet.add(ri);
                } else {
                    mat[ri][ci] = colSum[ci];
                    rowSum[ri] -= colSum[ci];
                    cSet.add(ci);
                }
            }

            return mat;
        }

        private int minInd(int[] a, Set<Integer> set) {
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < min && !set.contains(i)) {
                    min = a[i];
                    ind = i;
                }
            }
            return ind;
        }
    }
}
