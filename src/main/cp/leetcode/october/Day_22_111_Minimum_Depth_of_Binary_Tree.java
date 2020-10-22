package main.cp.leetcode.october;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day_22_111_Minimum_Depth_of_Binary_Tree {
    // DFS
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 1;
            if (root.left == null)
                return 1 + minDepth(root.right);
            if (root.right == null)
                return 1 + minDepth(root.left);
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    //BFS
    class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            int depth = 1;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    root = q.poll();
                    if (root.left == null && root.right == null)
                        return depth;
                    if (root.left != null)
                        q.add(root.left);
                    if (root.right != null)
                        q.add(root.right);
                }
                depth++;
            }
            return 0;
        }
    }
}
