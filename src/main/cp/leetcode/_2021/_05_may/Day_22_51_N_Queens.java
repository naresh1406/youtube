package main.cp.leetcode._2021._05_may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naresh Gupta on 23/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=ycB474iLuoQ
 */
public class Day_22_51_N_Queens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++)
                Arrays.fill(board[i], '.');

            List<List<String>> result = new ArrayList<>();
            backtrack(n, board, 0, result);

            return result;
        }

        private void backtrack(int n, char[][] board, int row, List<List<String>> result) {
            if (row == n) {
                result.add(constructBoard(board));
                return;
            }

            for (int col = 0; col < n; col++) {
                if (canPlaceQueen(board, row, col)) {
                    board[row][col] = 'Q';
                    backtrack(n, board, row + 1, result);
                    board[row][col] = '.'; // backtrack
                }
            }
        }

        private boolean canPlaceQueen(char[][] board, int row, int col) {
            // column check
            for (int i = row - 1; i >= 0; i--)
                if (board[i][col] == 'Q')
                    return false;

            // diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 'Q')
                    return false;

            // anti-diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
                if (board[i][j] == 'Q')
                    return false;

            return true;
        }

        private List<String> constructBoard(char[][] board) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < board.length; i++)
                result.add(new String(board[i]));

            return result;
        }
    }
}
