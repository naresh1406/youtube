package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 31/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=5TddjTZbphc
 */
public class _0042_Trapping_Rain_Water {
    // TC - O(N ^ 2), SC - O(1)
    class Solution_1 {
        public int trap(int[] H) {
            int n = H.length;
            if (n == 0)
                return 0;
            int water = 0;
            int leftMax = H[0];
            for (int i = 1; i < n - 1; i++) {
                leftMax = Math.max(leftMax, H[i]);
                int rightMax = 0;
                for (int j = i; j < n; j++)
                    rightMax = Math.max(rightMax, H[j]);
                water += Math.min(leftMax, rightMax) - H[i];
            }

            return water;
        }
    }

    // TC - O(N), SC - O(N)
    class Solution_2 {
        public int trap(int[] H) {
            int n = H.length;
            if (n == 0)
                return 0;

            int[] left = new int[n];
            left[0] = H[0];
            for (int i = 1; i < n; i++)
                left[i] = Math.max(left[i - 1], H[i]);

            int[] right = new int[n];
            right[n - 1] = H[n - 1];
            for (int i = n - 2; i >= 0; i--)
                right[i] = Math.max(right[i + 1], H[i]);

            int water = 0;
            for (int i = 0; i < n; i++)
                water += Math.max(0, Math.min(left[i], right[i]) - H[i]);

            return water;
        }
    }

    // TC - O(N), SC - O(1)
    class Solution_3 {
        public int trap(int[] H) {
            int n = H.length;
            if (n == 0)
                return 0;

            int maxIndex = 0, maxValue = 0;
            for (int i = 0; i < n; i++) {
                if (H[i] > maxValue) {
                    maxValue = H[i];
                    maxIndex = i;
                }
            }

            int water = 0;
            int leftMax = 0;
            for (int i = 0; i < maxIndex; i++) {
                leftMax = Math.max(leftMax, H[i]);
                water += leftMax - H[i];
            }

            int rightMax = 0;
            for (int i = n - 1; i > maxIndex; i--) {
                rightMax = Math.max(rightMax, H[i]);
                water += rightMax - H[i];
            }

            return water;
        }
    }
}
