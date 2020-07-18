package main.cp.leetcode.july;

import java.util.*;

/**
 * Day_18_Course_Schedule_II
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
 */
public class Day_18_Course_Schedule_II {
    // 1. BFS + Indegree
    class Solution {
        // TC - O(V + E), V - numCourses, E - number of edgese0
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // build graph and indegree array
            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++)
                graph[i] = new ArrayList();

            int[] indegree = new int[numCourses];
            for (int[] p : prerequisites) {
                graph[p[1]].add(p[0]);
                indegree[p[0]]++;
            }

            int[] order = new int[numCourses];
            int index = 0;

            // Initialize queue and add all courses having indegree 0
            Queue<Integer> queue = new LinkedList();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    order[index++] = i;
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int c : graph[current]) {
                    indegree[c]--;
                    if (indegree[c] == 0) {
                        queue.add(c);
                        order[index++] = c;
                    }
                }
            }

            return index == numCourses ? order : new int[0];
        }
    }

    // 2. Without building Graph
    class Solution2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] order = new int[numCourses];
            int[] indegree = new int[numCourses];
            int index = 0;
            for (int i = 0; i < prerequisites.length; i++)
                indegree[prerequisites[i][0]]++;

            // Initialize queue and add all courses having indegree 0
            Queue<Integer> queue = new LinkedList();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    order[index++] = i;
                }
            }

            while (!queue.isEmpty()) {
                int prerequisite = queue.poll();
                for (int i = 0; i < prerequisites.length; i++) {
                    if (prerequisites[i][1] == prerequisite) {
                        indegree[prerequisites[i][0]]--;
                        if (indegree[prerequisites[i][0]] == 0) {
                            // If indegree is zero, then add the course to the order.
                            order[index++] = prerequisites[i][0];
                            queue.offer(prerequisites[i][0]);
                        }
                    }
                }
            }

            return index == numCourses ? order : new int[0];
        }
    }

    // 3. DFS
    class Solution3 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++)
                graph[i] = new ArrayList();

            for (int[] p : prerequisites)
                graph[p[1]].add(p[0]);

            boolean visited[] = new boolean[numCourses];
            boolean recStack[] = new boolean[numCourses];
            Stack<Integer> topStack = new Stack();

            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == false) {
                    boolean cyclePresent = dfs(graph, visited, i, topStack, recStack);
                    if (cyclePresent) return new int[0];
                }
            }

            int order[] = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                order[i] = topStack.pop();

            return order;
        }

        private boolean dfs(List<Integer>[] graph, boolean visited[], int start, Stack<Integer> topStack, boolean recStack[]) {
            visited[start] = true;
            recStack[start] = true;
            for (int c : graph[start]) {
                if (!visited[c] && dfs(graph, visited, c, topStack, recStack)) return true;
                else if (recStack[c]) return true;
            }
            recStack[start] = false;
            topStack.push(start);
            return false;
        }
    }
}