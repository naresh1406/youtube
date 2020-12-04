package main.cp.leetcode.december;

import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Naresh Gupta on 4/12/2020 AD.
 */
public class Day_03_897_Increasing_Order_Search_Tree {
    // Solution 1: Traversal + Tree Construction
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> list = new ArrayList();
            inorder(root, list);
            TreeNode dummyRoot = new TreeNode(0);
            TreeNode current = dummyRoot;
            for (int v : list) {
//                current = current.right = new TreeNode(v);
                current.right = new TreeNode(v);
                current = current.right;
            }
            return dummyRoot.right;
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    // Solution 2: Traversal and Linking both together
    class Solution2 {
        TreeNode current;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummyRoot = new TreeNode(0);
            current = dummyRoot;
            inorder(root);
            return dummyRoot.right;
        }

        private void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            root.left = null;
            current = current.right = root;
            inorder(root.right);
        }
    }

    // Solution 3:Iterative
    class Solution3 {
        public TreeNode increasingBST(TreeNode root) {
            Stack<TreeNode> s = new Stack();
            s.add(root);
            TreeNode dummyRoot = new TreeNode(0);
            TreeNode current = dummyRoot;

            root = root.left;
            while (!s.isEmpty() || root != null) {
                while (root != null) {
                    s.add(root);
                    root = root.left;
                }

                TreeNode temp = s.pop();
                current = current.right = new TreeNode(temp.val);

                if (temp.right != null)
                    root = temp.right;
            }

            return dummyRoot.right;
        }
    }
}
