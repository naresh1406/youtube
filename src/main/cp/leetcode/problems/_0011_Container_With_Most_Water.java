package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 11/12/2020 AD.
 */
public class _0011_Container_With_Most_Water {
    class Solution {
        // TC - O(n)
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, maxArea = 0;
            while (i < j) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
                if (height[i] < height[j])
                    i++;
                else
                    j--;
            }
            return maxArea;
        }
    }

    class Solution2 {
        // TC - O(n^2)
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length; i++)
                for (int j = i + 1; j < height.length; j++)
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            return maxArea;
        }
    }
}
