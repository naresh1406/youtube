package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Naresh Gupta on 30/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=r66aO7NLjPE
 */
public class Day_29_987_Vertical_Order_Traversal_of_a_Binary_Tree {
    class Solution {
        class Point {
            int x;
            int y;
            int val;

            public Point(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            if (root == null)
                return new ArrayList();

            List<Point> list = new ArrayList();
            vtUtil(root, 0, 0, list);

            // Sort points based on x then y then value
            Collections.sort(list, (p1, p2) -> p1.x == p2.x ? p1.y == p2.y ? p1.val - p2.val : p2.y - p1.y : p1.x - p2.x);

            // Build treeMap with key as x value of node
            Map<Integer, List<Integer>> map = new TreeMap();
            for (Point p : list) {
                List<Integer> line = map.getOrDefault(p.x, new ArrayList());
                line.add(p.val);
                map.put(p.x, line);
            }

            // Construct result List<List<Integer>>
            List<List<Integer>> result = new ArrayList();
            for (List<Integer> l : map.values())
                result.add(l);

            return result;
        }

        private void vtUtil(TreeNode root, int x, int y, List<Point> list) {
            if (root == null)
                return;
            list.add(new Point(x, y, root.val));
            vtUtil(root.left, x - 1, y - 1, list);
            vtUtil(root.right, x + 1, y - 1, list);
        }
    }

    // 2. Solution 2
    class Solution2 {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList();
            if (root == null) return result;

            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();
            vtUtil(root, 0, 0, map);

            for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
                List<Integer> line = new ArrayList();
                for (PriorityQueue<Integer> pq : entry.getValue().values()) {
                    while (pq.size() > 0)
                        line.add(pq.poll());
                }
                result.add(line);
            }

            return result;
        }

        private void vtUtil(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
            if (root == null)
                return;

            TreeMap<Integer, PriorityQueue<Integer>> m = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue();
            if (map.containsKey(x)) {
                m = map.get(x);
                if (m.containsKey(y)) {
                    pq = m.get(y);
                }
            }
            pq.add(root.val);
            m.put(y, pq);
            map.put(x, m);

            vtUtil(root.left, x - 1, y + 1, map);
            vtUtil(root.right, x + 1, y + 1, map);
        }
    }
}