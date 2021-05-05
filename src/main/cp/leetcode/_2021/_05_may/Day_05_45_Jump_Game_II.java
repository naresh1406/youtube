package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 5/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=OExhTm1747c
 */
public class Day_05_45_Jump_Game_II {
    class Solution_Recursive {
        public int jump(int[] A) {
            return helper(A, 0);
        }

        private int helper(int[] A, int start) {
            if (start >= A.length - 1)
                return 0;

            int minJump = Integer.MAX_VALUE;
            for (int i = start + 1; i <= start + A[start]; i++)
                minJump = Math.min(minJump, 1 + helper(A, i));

            return minJump;
        }
    }

    class Solution_TopDownDP {
        Integer[] dp;

        public int jump(int[] A) {
            dp = new Integer[A.length];
            return helper(A, 0);
        }

        private int helper(int[] A, int start) {
            if (start >= A.length - 1)
                return 0;
            if (dp[start] != null)
                return dp[start];

            int minJump = Integer.MAX_VALUE;
            for (int i = start + 1; i <= start + A[start]; i++)
                minJump = Math.min(minJump, 1 + helper(A, i));

            return dp[start] = minJump;
        }
    }

    class Solution_Greedy {
        public int jump(int[] A) {
            int jump = 0, currentEnd = 0, nextEnd = 0;
            for (int i = 0; i < A.length - 1; i++) {
                nextEnd = Math.max(nextEnd, i + A[i]);
                if (i == currentEnd) {
                    jump++;
                    currentEnd = nextEnd;
                }
            }

            return jump;
        }
    }
}
