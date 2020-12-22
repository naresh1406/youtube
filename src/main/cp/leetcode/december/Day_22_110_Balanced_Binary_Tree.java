package main.cp.leetcode.december;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 22/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/icxndJkKUuc?t=0
 */
public class Day_22_110_Balanced_Binary_Tree {
    // Time - O(n)

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        private int height(TreeNode node) {
            if (node == null)
                return 0;
            int left = height(node.left);
            int right = height(node.right);
            if (left == -1 || right == -1 || Math.abs(left - right) > 1)
                return -1;
            return Math.max(left, right) + 1;
        }
    }

    // Time - O(nlogn)

    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode node) {
            if (node == null)
                return 0;
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
