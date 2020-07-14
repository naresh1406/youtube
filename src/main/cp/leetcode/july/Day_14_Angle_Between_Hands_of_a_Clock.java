package main.cp.leetcode.july;

/**
 * Day_14_Angle_Between_Hands_of_a_Clock
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
 */
public class Day_14_Angle_Between_Hands_of_a_Clock {
    class Solution {
        public double angleClock(int hour, int minutes) {
            double angle = Math.abs(30.0 * hour + 0.5 * minutes - 6.0 * minutes);
            return angle <= 180.0 ? angle : 360 - angle;
        }
    }
}
