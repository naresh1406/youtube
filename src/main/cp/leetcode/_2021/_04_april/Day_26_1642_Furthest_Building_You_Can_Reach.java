package main.cp.leetcode._2021._04_april;

import java.util.PriorityQueue;

/**
 * Created by Naresh Gupta on 30/4/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=feNHy3-FzRY
 */
public class Day_26_1642_Furthest_Building_You_Can_Reach {
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> minHeap = new PriorityQueue();
            for (int i = 0; i < heights.length - 1; i++) {
                int diff = heights[i + 1] - heights[i];
                if (diff <= 0)
                    continue;
                minHeap.offer(diff);
                if (minHeap.size() > ladders)
                    bricks -= minHeap.poll();
                if (bricks < 0)
                    return i;
            }

            return heights.length - 1;
        }
    }
}
