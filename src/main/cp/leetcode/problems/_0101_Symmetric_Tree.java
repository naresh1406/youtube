package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 20/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=9bt2EGAMEqU
 */
public class _0101_Symmetric_Tree {
    class Solution_DFS {
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        private boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            else if (p == null || q == null)
                return false;
            return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
    }

    class Solution_BFS {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            queue.offer(root);
            while (queue.size() > 0) {
                TreeNode p = queue.poll();
                TreeNode q = queue.poll();
                if (p == null && q == null)
                    continue;
                if (p == null || q == null)
                    return false;
                if (p.val != q.val)
                    return false;
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }

            return true;
        }
    }
}
