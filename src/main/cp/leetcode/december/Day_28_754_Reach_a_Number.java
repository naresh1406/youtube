package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 29/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/F23zJlz__SM?t=0
 */
public class Day_28_754_Reach_a_Number {
    // TC - O(√target)
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int steps = 0, sum = 0;
            while (sum < target)
                sum += ++steps;
            return (sum - target) % 2 == 0 ? steps : steps % 2 == 0 ? steps + 1 : steps + 2;
        }
    }

    class Solution2 {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int steps = (int) Math.ceil((-1 + Math.sqrt(1 + 8.0 * target)) / 2);
            int sum = (steps * (steps + 1)) / 2;
            return (sum - target) % 2 == 0 ? steps : steps % 2 == 0 ? steps + 1 : steps + 2;
        }
    }

    // Recursive - Throw Error as our Input is very big

    class Solution3 {
        public int reachNumber(int target) {
            return minSteps(Math.abs(target), 0, 0);
        }

        private int minSteps(int target, int source, int steps) {
            if (Math.abs(source) > target)
                return Integer.MAX_VALUE;
            if (source == target)
                return steps;
            return Math.min(minSteps(target, source + steps + 1, steps + 1), minSteps(target, source - steps - 1, steps + 1));
        }
    }
}
