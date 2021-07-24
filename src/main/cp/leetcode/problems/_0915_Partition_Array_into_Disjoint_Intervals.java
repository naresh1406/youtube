package main.cp.leetcode.problems;


/**
 * Created by Naresh Gupta on 22/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Ei5CN9_BHNU
 */
public class _0915_Partition_Array_into_Disjoint_Intervals {
    // TC - O(N^2), SC - O(1)
    class Solution_1 {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;
            int leftMax = 0;
            for (int i = 0; i < n; i++) {
                leftMax = Math.max(leftMax, nums[i]);
                int rightMin = Integer.MAX_VALUE;
                for (int j = i + 1; j < n; j++)
                    rightMin = Math.min(rightMin, nums[j]);
                if (leftMax <= rightMin)
                    return i + 1;
            }

            return n;
        }
    }

    // TC - O(N), SC - O(N)
    class Solution_2 {
        public int partitionDisjoint(int[] nums) {
            int n = nums.length;

            int[] leftMax = new int[n];
            leftMax[0] = nums[0];
            for (int i = 1; i < n; i++)
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);

            int[] rightMin = new int[n];
            rightMin[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--)
                rightMin[i] = Math.min(rightMin[i + 1], nums[i]);

            for (int i = 1; i < n; i++)
                if (leftMax[i - 1] <= rightMin[i])
                    return i;

            return n - 1;
        }
    }

    // TC - O(N), SC - O(1)
    class Solution_3 {
        public int partitionDisjoint(int[] nums) {
            int leftMax = nums[0], globalMax = nums[0], n = nums.length;
            int index = 0;
            for (int i = 1; i < n; i++) {
                globalMax = Math.max(globalMax, nums[i]);
                if (nums[i] < leftMax) {
                    leftMax = globalMax;
                    index = i;
                }
            }

            return index + 1;
        }
    }
}
