package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _1609_Even_Odd_Tree {
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            if (root == null) return true;
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            boolean even = true;
            while (q.size() > 0) {
                int size = q.size();
                int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE; // init preVal based on level even or odd
                while (size-- > 0) { // level by level
                    root = q.poll();
                    if (even && (root.val % 2 == 0 || root.val <= prevVal)) return false; // invalid case on even level
                    if (!even && (root.val % 2 == 1 || root.val >= prevVal)) return false; // invalid case on odd level
                    prevVal = root.val; // update the prev value
                    if (root.left != null) q.add(root.left); // add left child if exist
                    if (root.right != null) q.add(root.right); // add right child if exist
                }
                even = !even; // alter the levels
            }

            return true;
        }
    }
}
