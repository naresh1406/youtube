package main.cp.leetcode.july;

import java.util.*;

/**
 * Day_24_All_Paths_From_Source_to_Target
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
 */
public class Day_24_All_Paths_From_Source_to_Target {
    // 1. DFS
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList();
            dfs(graph, 0, graph.length - 1, new ArrayList(), result);
            return result;
        }

        private void dfs(int[][] graph, int source, int destination, List<Integer> list, List<List<Integer>> result) {
            if (source == destination) result.add(list); // if soruce reached destination add that path in result
            list.add(source); // add current vertex
            for (Integer vertex : graph[source]) {
                List<Integer> copyList = new ArrayList<>(list); // clone the path
                dfs(graph, vertex, destination, copyList, result);
            }
        }
    }

    // 2. BFS
    class Solution2 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new ArrayList();
            Queue<List<Integer>> queue = new LinkedList();
            queue.add(Arrays.asList(0));
            int destination = graph.length - 1;

            while (!queue.isEmpty()) {
                List<Integer> path = queue.poll();
                int current = path.get(path.size() - 1);
                if (current == destination)
                    result.add(new ArrayList(path));
                for (int node : graph[current]) {
                    List<Integer> newPath = new ArrayList(path);
                    newPath.add(node);
                    queue.add(newPath);
                }
            }

            return result;
        }
    }
}