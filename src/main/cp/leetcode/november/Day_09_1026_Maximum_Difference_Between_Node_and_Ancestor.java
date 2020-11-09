package main.cp.leetcode.november;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 9/11/2020 AD.
 */
public class Day_09_1026_Maximum_Difference_Between_Node_and_Ancestor {

    // O(N)
    class Solution {
        int result = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root, root.val, root.val);
            return result;
        }

        private void dfs(TreeNode node, int curMax, int curMin) {
            if (node == null)
                return;
            result = Math.max(result, Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val)));
            curMax = Math.max(curMax, node.val);
            curMin = Math.min(curMin, node.val);
            dfs(node.left, curMax, curMin);
            dfs(node.right, curMax, curMin);
        }
    }

    // O(N^2)
    class Solution2 {
        int result = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return result;
        }

        private void dfs(TreeNode root) {
            if (root == null)
                return;

            if (root.left != null) {
                result = Math.max(result, Math.abs(root.val - minSub(root.left)));
                result = Math.max(result, Math.abs(root.val - maxSub(root.left)));
            }

            if (root.right != null) {
                result = Math.max(result, Math.abs(root.val - minSub(root.right)));
                result = Math.max(result, Math.abs(root.val - maxSub(root.right)));
            }

            dfs(root.left);
            dfs(root.right);
        }

        private int maxSub(TreeNode root) {
            return root == null ? Integer.MIN_VALUE : Math.max(root.val, Math.max(maxSub(root.left), maxSub(root.right)));
        }

        private int minSub(TreeNode root) {
            return root == null ? Integer.MAX_VALUE : Math.min(root.val, Math.min(minSub(root.left), minSub(root.right)));
        }
    }
}
