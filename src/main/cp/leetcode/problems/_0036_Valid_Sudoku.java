package main.cp.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 28/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=7gIlJKVK4Ok
 */
public class _0036_Valid_Sudoku {
    class Solution_1 {
        public boolean isValidSudoku(char[][] board) {
            int m = board.length, n = board[0].length;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (board[r][c] != '.') {
                        if (!isValid(board, r, c, board[r][c], m, n)) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        private boolean isValid(char[][] board, int r, int c, char ch, int m, int n) {
            // row
            for (int j = 0; j < n; j++)
                if (j != c && board[r][j] == ch)
                    return false;

            // col
            for (int i = 0; i < m; i++)
                if (i != r && board[i][c] == ch)
                    return false;

            // block
            int ri = 3 * (r / 3);
            int ci = 3 * (c / 3);

            for (int i = ri; i < ri + 3; i++)
                for (int j = ci; j < ci + 3; j++)
                    if (i != r && j != c && board[i][j] == ch)
                        return false;

            return true;
        }
    }

    class Solution_2 {
        public boolean isValidSudoku(char[][] board) {
            Set<String> set = new HashSet();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    char number = board[i][j];
                    if (number != '.')
                        if (!set.add(number + " in row " + i) || !set.add(number + " in col " + j) || !set.add(number + " in block " + i / 3 + "-" + j / 3))
                            return false;
                }
            }

            return true;
        }
    }
}
