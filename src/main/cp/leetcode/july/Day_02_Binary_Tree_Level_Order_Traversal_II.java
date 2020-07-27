package main.cp.leetcode.july;

import main.cp.leetcode.TreeNode;

import java.util.*;

/**
 * Day 01 Arranging Coins
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
 */
public class Day_02_Binary_Tree_Level_Order_Traversal_II {

    // 1. Using Collections Reverse
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return new ArrayList();
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> queue = new LinkedList();

            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList();
                while (size-- > 0) {
                    root = queue.poll();
                    level.add(root.val);
                    if (root.left != null)
                        queue.add(root.left);
                    if (root.right != null)
                        queue.add(root.right);
                }
                result.add(level);
            }

            Collections.reverse(result);
            return result;
        }
    }

    // 2.Append
    class Solution2 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return new ArrayList();
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> queue = new LinkedList();

            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList();
                while (size-- > 0) {
                    root = queue.poll();
                    level.add(root.val);
                    if (root.left != null)
                        queue.add(root.left);
                    if (root.right != null)
                        queue.add(root.right);
                }
                result.add(0, level);
            }

            return result;
        }
    }

    // 3. Using Stack
    class Solution3 {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) return new ArrayList();
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> queue = new LinkedList();
            java.util.Stack<List<Integer>> stack = new Stack();

            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList();
                while (size-- > 0) {
                    root = queue.poll();
                    level.add(root.val);
                    if (root.left != null)
                        queue.add(root.left);
                    if (root.right != null)
                        queue.add(root.right);
                }
                stack.add(level);
            }

            while (!stack.isEmpty())
                result.add(stack.pop());

            return result;
        }
    }
}
