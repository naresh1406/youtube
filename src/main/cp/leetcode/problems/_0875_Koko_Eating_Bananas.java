package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 13/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=yBU4tsVg7-c
 */
public class _0875_Koko_Eating_Bananas {
    class Solution_BruteForce {
        public int minEatingSpeed(int[] piles, int h) {
            int k = 1;
            for (; k < 1_000_000_001; k++) {
                int time = 0;
                for (int p : piles) {
                    time += (p - 1) / k + 1;
                    if (time > h)
                        break;
                }

                if (time <= h)
                    break;
            }

            return k;
        }
    }

    class Solution_BinarySearch {
        // TC - O(nlog(D)
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1, high = 1_000_000_000;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (isPossible(piles, h, mid))
                    high = mid;
                else
                    low = mid + 1;
            }

            return low;
        }

        private boolean isPossible(int[] piles, int h, int k) {
            int time = 0;
            for (int p : piles) {
                time += (p - 1) / k + 1;
                if (time > h)
                    break;
            }

            return time <= h;
        }
    }
}
