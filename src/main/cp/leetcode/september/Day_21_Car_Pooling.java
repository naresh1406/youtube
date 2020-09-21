package main.cp.leetcode.september;

import java.util.Arrays;

public class Day_21_Car_Pooling {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] count = new int[1001];
            for (int[] t : trips)
                for (int i = t[1]; i < t[2]; i++)
                    count[i] += t[0];
            return Arrays.stream(count).max().getAsInt() <= capacity;
        }
    }

    class Solution2 {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] timestamp = new int[1001];
            for (int[] t : trips) {
                timestamp[t[1]] += t[0];
                timestamp[t[2]] -= t[0];
            }

            for (int number : timestamp) {
                capacity -= number;
                if (capacity < 0)
                    return false;
            }

            return true;
        }
    }
}
