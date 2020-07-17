package main.cp.leetcode.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Day 03 Prison Cells After N Days
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/
 */
public class Day_03_Prison_Cells_After_N_Days {
    // 1. Brute Force
    class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            for (int i = 0; i < N; i++)
                cells = nextDayState(cells);
            return cells;
        }

        private int[] nextDayState(int[] cells) {
            int[] next = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++)
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            return next;
        }
    }

    // 2. Cycle with Seen
    class Solution2 {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Set<String> seen = new HashSet();
            boolean cycle = false;
            int len = 0;
            for (int i = 0; i < N; i++) {
                int[] next = nextDayState(cells);
                String key = Arrays.toString(next);
                if (seen.contains(key)) {
                    cycle = true;
                    break;
                }
                seen.add(key);
                len++;
                cells = next;
            }

            if (cycle)
                return prisonAfterNDays(cells, N % len);
            return cells;
        }

        private int[] nextDayState(int[] cells) {
            int[] next = new int[cells.length];
            for (int i = 1; i < 7; i++)
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            return next;
        }
    }

    // 1, 7, 14 Cycle
    class Solution3 {
        public int[] prisonAfterNDays(int[] cells, int N) {
            N = (N - 1) % 14 + 1;
            for (int i = 0; i < N; i++)
                cells = nextDayState(cells);
            return cells;
        }

        private int[] nextDayState(int[] cells) {
            int[] next = new int[cells.length];
            for (int i = 1; i < cells.length - 1; i++)
                next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            return next;
        }
    }
}
