package main.cp.leetcode._2021._01_january;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 15/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=UHiL3ckUV04
 */
public class Day_13_881_Boats_to_Save_People {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int l = 0, r = people.length - 1, boats = 0;

            while (l <= r) {
                if (people[l] + people[r] <= limit)
                    l++;
                r--;
                boats++;
            }

            return boats;
        }
    }
}
