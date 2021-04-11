package main.cp.leetcode._2021._04_april;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 11/4/2021 AD.
 */
public class Day_11_1302_Deepest_Leaves_Sum {
    // DFS TC - O(n), SC - O(h)
    class Solution {
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            int maxDepth = maxDepth(root);
            helper(root, 1, maxDepth);
            return sum;
        }

        private void helper(TreeNode root, int d, int maxDepth) {
            if (root == null)
                return;
            if (root.left == null && root.right == null && d == maxDepth)
                sum += root.val;
            helper(root.left, d + 1, maxDepth);
            helper(root.right, d + 1, maxDepth);
        }

        private int maxDepth(TreeNode root) {
            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    // BFS TC - O(n), SC - O(n)
    class Solution2 {
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);
            int sum = 0;
            while (q.size() > 0) {
                sum = 0;
                for (int i = q.size(); i > 0; i--) {
                    root = q.poll();
                    sum += root.val;
                    if (root.left != null)
                        q.offer(root.left);
                    if (root.right != null)
                        q.offer(root.right);
                }
            }

            return sum;
        }
    }
}
