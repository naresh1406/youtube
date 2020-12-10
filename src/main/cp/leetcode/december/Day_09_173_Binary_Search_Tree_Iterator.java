package main.cp.leetcode.december;

import main.cp.leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 10/12/2020 AD.
 */
public class Day_09_173_Binary_Search_Tree_Iterator {
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack();
            pushLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null)
                pushLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return stack.size() > 0;
        }

        private void pushLeft(TreeNode root) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
        }
    }
}
