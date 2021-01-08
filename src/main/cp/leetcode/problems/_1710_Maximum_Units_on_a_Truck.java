package main.cp.leetcode.problems;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 9/1/2021 AD.
 */
public class _1710_Maximum_Units_on_a_Truck {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> -Integer.compare(a[1], b[1]));
            int maxUnits = 0;
            for (int[] box : boxTypes) {
                if (truckSize < box[0]) {
                    return maxUnits + truckSize * box[1];
                }
                maxUnits += box[0] * box[1];
                truckSize -= box[0];
            }

            return maxUnits;
        }
    }
}
