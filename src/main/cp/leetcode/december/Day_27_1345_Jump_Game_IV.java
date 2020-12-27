package main.cp.leetcode.december;

import java.util.*;

/**
 * Created by Naresh Gupta on 28/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/vC9C5xRwbHY?t=0
 */
public class Day_27_1345_Jump_Game_IV {
    // TC - O(N), SC - O(N)
    class Solution {
        public int minJumps(int[] arr) {
            int n = arr.length;
            Map<Integer, List<Integer>> valIndex = new HashMap();
            for (int i = 0; i < n; i++)
                valIndex.computeIfAbsent(arr[i], l -> new ArrayList()).add(i);

            Queue<Integer> q = new LinkedList();
            Set<Integer> visited = new HashSet();

            q.add(0);
            visited.add(0);
            int steps = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int i = q.poll();
                    if (n - 1 == i)
                        return steps;
                    List<Integer> adjList = valIndex.get(arr[i]);
                    adjList.add(i - 1);
                    adjList.add(i + 1);
                    for (int j : adjList) {
                        if (j >= 0 && j < n && !visited.contains(j)) {
                            q.add(j);
                            visited.add(j);
                        }
                    }
                    adjList.clear(); // stop repeated calculations
                }
                steps++;
            }

            return -1;
        }
    }
}
