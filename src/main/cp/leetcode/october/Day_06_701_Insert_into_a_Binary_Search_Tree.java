package main.cp.leetcode.october;

import main.cp.leetcode.TreeNode;

public class Day_06_701_Insert_into_a_Binary_Search_Tree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            } else if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
            return root;
        }
    }

    class Solution2 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            TreeNode current = root;
            while (true) {
                if (current.val < val) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new TreeNode(val);
                        break;
                    }
                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }
}
