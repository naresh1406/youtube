package main.cp.leetcode.october;

/**
 * Created by Naresh Gupta on 29/10/2020 AD.
 * Detailed Video Explanation https://youtu.be/Zoi9JyGpCX8?t=0
 */
public class Day_29_849_Maximize_Distance_to_Closest_Person {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int l = -1, n = seats.length, maxDist = 0;
            for(int i = 0; i < n; i++) {
                if(seats[i] == 1) {
                    if(l == -1)
                        maxDist = i;
                    else
                        maxDist = Math.max(maxDist, (i - l) / 2);
                    l = i;
                }
            }

            if(seats[n - 1] == 0)
                maxDist = Math.max(maxDist, n - 1 - l);

            return maxDist;
        }
    }
}
