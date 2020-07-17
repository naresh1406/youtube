package main.cp.leetcode.july;

import java.util.*;

/**
 * Day_09_Maximum_Width_of_Binary_Tree
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
 */
public class Day_09_Maximum_Width_of_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 1. BFS
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;
            Deque<TreeNode> deque = new LinkedList<>(); // initialize deque
            deque.add(root); // add root node in deque
            int maxWidth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size(); // size of current level
                maxWidth = Math.max(maxWidth, size);
                while (size-- > 0) {
                    TreeNode node = deque.poll();
                    if (node == null) { // node was null then to maintain add both left and right as null
                        deque.add(null);
                        deque.add(null);
                    } else {
                        deque.add(node.left);
                        deque.add(node.right);
                    }
                }
                while (!deque.isEmpty() && deque.peekFirst() == null)
                    deque.pollFirst(); // remove all the null from the start until encounter first last non null node of level
                while (!deque.isEmpty() && deque.peekLast() == null)
                    deque.pollLast(); // remove all the null from the last until encounter last non null node of level
            }
            return maxWidth;
        }
    }

    // 2. DFS
    class Solution2 {
        public int widthOfBinaryTree(TreeNode root) {
            List<Integer> levelLMN = new ArrayList<>(); // levelLMN level left most node
            return dfs(root, 1, 0, levelLMN);
        }

        private int dfs(TreeNode root, int id, int level, List<Integer> levelLMN) {
            if (root == null) return 0;
            if (level == levelLMN.size()) levelLMN.add(id); // add left most node
            return Math.max(id + 1 - levelLMN.get(level),
                    Math.max(dfs(root.left, id * 2, level + 1, levelLMN),
                            dfs(root.right, id * 2 + 1, level + 1, levelLMN)));
        }
    }
}
