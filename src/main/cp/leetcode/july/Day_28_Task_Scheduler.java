package main.cp.leetcode.july;

import java.util.Arrays;

/**
 * Day_28_Task_Scheduler
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
 */
public class Day_28_Task_Scheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] f = new int[26];
            for (char task : tasks)
                f[task - 'A']++;

            Arrays.sort(f);
            int chunk = f[25] - 1;
            int idleSpots = chunk * n;

            for (int i = 24; i >= 0; i--)
                idleSpots -= Math.min(chunk, f[i]);

            return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
        }
    }
}
