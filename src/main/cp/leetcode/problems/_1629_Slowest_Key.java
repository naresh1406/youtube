package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 7/9/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=CzrWL1qWfb8
 */
public class _1629_Slowest_Key {
    class Solution {
        public char slowestKey(int[] rt, String key) {
            int maxTime = rt[0];
            char result = key.charAt(0);

            for (int i = 1; i < rt.length; i++) {
                int currentTime = rt[i] - rt[i - 1];
                if (currentTime > maxTime || currentTime == maxTime && key.charAt(i) > result) {
                    maxTime = currentTime;
                    result = key.charAt(i);
                }
            }

            return result;
        }
    }
}
