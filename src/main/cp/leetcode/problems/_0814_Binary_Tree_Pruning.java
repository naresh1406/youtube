package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 23/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=-LCnJZdj59c
 */
public class _0814_Binary_Tree_Pruning {
    // TC - O(N), SC - O(H), H - Height of tree
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root == null)
                return null;
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            if (root.left == null && root.right == null && root.val == 0)
                return null;

            return root;
        }
    }
}
