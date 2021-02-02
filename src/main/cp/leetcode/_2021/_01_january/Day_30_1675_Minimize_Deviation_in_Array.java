package main.cp.leetcode._2021._01_january;

import java.util.TreeSet;

/**
 * Created by Naresh Gupta on 3/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=M7VmwWAnpUE
 */
public class Day_30_1675_Minimize_Deviation_in_Array {
    class Solution {
        public int minimumDeviation(int[] nums) {
            TreeSet<Integer> set = new TreeSet();
            for (int n : nums) {
                if (n % 2 == 1)
                    set.add(2 * n);
                else
                    set.add(n);
            }

            int deviation = Integer.MAX_VALUE;

            while (true) {
                int max = set.last();
                deviation = Math.min(deviation, max - set.first());
                if (max % 2 == 0) {
                    set.remove(max);
                    set.add(max / 2);
                } else {
                    break;
                }
            }

            return deviation;
        }
    }
}
