package main.cp.leetcode.july;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Day_13_Same_Tree
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
 */
public class Day_13_Same_Tree {
    // 1. Recursive | DFS | Preorder
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null || p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    // 2. Iterative using 1 Queue
    class Solution2 {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(p);
            queue.add(q);
            while (!queue.isEmpty()) {
                p = queue.poll();
                q = queue.poll();
                if (p == null && q == null) {
                    continue;
                } else if (p == null || q == null || p.val != q.val) {
                    return false;
                }
                queue.add(p.left);
                queue.add(q.left);
                queue.add(p.right);
                queue.add(q.right);
            }
            return true;
        }
    }
}
