package main.cp.leetcode.december;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 10/12/2020 AD.
 */
public class Day_08_1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap();
            for (int t : time) {
                if (t % 60 == 0)
                    count += map.getOrDefault(0, 0);
                else
                    count += map.getOrDefault(60 - t % 60, 0);
                map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
            }
            return count;
        }
    }

    // Brute Force -  TLE
    class Solution2 {
        public int numPairsDivisibleBy60(int[] time) {
            int pair = 0;
            for (int i = 0; i < time.length; i++) {
                for (int j = i + 1; j < time.length; j++) {
                    if ((time[i] + time[j]) % 60 == 0)
                        pair++;
                }
            }

            return pair;
        }
    }
}
