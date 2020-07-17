package main.cp.leetcode.july;

/**
 * Day 07 Island Perimeter
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
 */
public class Day_07_Island_Perimeter {
    // 1. 4 direction check
    class Solution {
        public int islandPerimeter(int[][] grid) {
            int r = grid.length;
            int c = grid[0].length;

            int perimeter = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == 1) { // if land
                        perimeter += 4;
                        if (i > 0) perimeter -= grid[i - 1][j]; //up
                        if (i < r - 1) perimeter -= grid[i + 1][j]; // down
                        if (j > 0) perimeter -= grid[i][j - 1]; //left
                        if (j < c - 1) perimeter -= grid[i][j + 1]; //right
                    }
                }
            }

            return perimeter;
        }
    }

    // 2. 2 direction check
    class Solution2 {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        perimeter += 4;
                        if (i < grid.length - 1) perimeter -= 2 * grid[i + 1][j];
                        if (j < grid[0].length - 1) perimeter -= 2 * grid[i][j + 1];
                    }
                }
            }

            return perimeter;
        }
    }

    // 3. DFS
    public class Solution3 {
        public int islandPerimeter(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        return getPerimeter(grid, i, j);
                    }
                }
            }
            return 0;
        }

        public int getPerimeter(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return 1; // if boundary cross water everywhere 1
            if (grid[i][j] == 0) return 1; // if call is water 1
            if (grid[i][j] == -1) return 0; // if already visited 0

            grid[i][j] = -1; // update with -1 to mark visited no need of visited matrix
            int perimeter = 0;
            perimeter += getPerimeter(grid, i - 1, j);
            perimeter += getPerimeter(grid, i, j - 1);
            perimeter += getPerimeter(grid, i, j + 1);
            perimeter += getPerimeter(grid, i + 1, j);

            return perimeter;
        }
    }
}
