package main.cp.leetcode.december;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 1/12/2020 AD.
 * Detailed Video Explanation https://youtu.be/jDrCmRpfJrk?t=0
 */
public class Day_01_104_Maximum_Depth_of_Binary_Tree {
    // DFS
    class Solution {
        public int maxDepth(TreeNode root) {
            return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    // BFS
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            int depth = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    root = q.poll();
                    if (root.left != null)
                        q.offer(root.left);
                    if (root.right != null)
                        q.offer(root.right);
                }
                depth++;
            }
            return depth;
        }
    }
}
