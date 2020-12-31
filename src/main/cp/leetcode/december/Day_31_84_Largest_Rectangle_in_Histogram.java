package main.cp.leetcode.december;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 31/12/2020 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=oV1vOlhTUe0
 */
public class Day_31_84_Largest_Rectangle_in_Histogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> st = new Stack();
            st.add(-1);
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                    int h = heights[st.pop()];
                    int w = i - st.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                st.add(i);
            }

            while (st.peek() != -1) {
                int h = heights[st.pop()];
                int w = heights.length - st.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            return maxArea;
        }
    }

    // D & C

    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            return calculateArea(heights, 0, heights.length - 1);
        }

        private int calculateArea(int[] heights, int start, int end) {
            if (start > end)
                return 0;
            int minindex = start;
            for (int i = start; i <= end; i++)
                if (heights[minindex] > heights[i])
                    minindex = i;
            return Math.max(heights[minindex] * (end - start + 1),
                    Math.max(calculateArea(heights, start, minindex - 1),
                            calculateArea(heights, minindex + 1, end)));
        }
    }

    // TC - O(n^2)

    class Solution3 {
        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int minH = heights[i];
                int area = heights[i];
                for (int j = i; j < heights.length; j++) {
                    minH = Math.min(minH, heights[j]);
                    area = Math.max(area, minH * (j - i + 1));
                }
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }
    }
}
