package main.cp.leetcode.december;

import java.util.*;

/**
 * Created by Naresh Gupta on 25/12/2020 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=-FEeaf3ufIE
 */
public class Day_25_498_Diagonal_Traverse {
    // TC - O(m * n), SC - O(1)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix.length == 0)
                return new int[0];

            int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
            int[] result = new int[m * n];

            for (int i = 0; i < result.length; i++) {
                result[i] = matrix[r][c];
                if ((r + c) % 2 == 0) {
                    if (c == n - 1) {
                        r++;
                    } else if (r == 0) {
                        c++;
                    } else {
                        r--;
                        c++;
                    }
                } else {
                    if (r == m - 1) {
                        c++;
                    } else if (c == 0) {
                        r++;
                    } else {
                        r++;
                        c--;
                    }
                }
            }

            return result;
        }
    }

    // TC - O(m * n), SC - O(m * n)

    class Solution2 {
        public int[] findDiagonalOrder(int[][] matrix) {
            int m = matrix.length;
            if (m == 0)
                return new int[0];
            int n = matrix[0].length;

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map.computeIfAbsent(i + j, l -> new ArrayList<>()).add(matrix[i][j]);
                }
            }

            List<Integer> result = new ArrayList();
            for (int k = 0; k < m + n - 1; k++) {
                List<Integer> list = map.get(k);
                if (k % 2 == 0)
                    Collections.reverse(list);
                result.addAll(list);
            }

            return result.stream().mapToInt(x -> x).toArray();
        }
    }
}
