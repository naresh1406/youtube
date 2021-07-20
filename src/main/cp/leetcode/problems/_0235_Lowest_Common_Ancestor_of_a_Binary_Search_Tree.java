package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 19/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=muQ5ZMEQxn4
 */
public class _0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    class Solution_Recursive {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return root;
            if (root.val >= p.val && root.val <= q.val || root.val >= q.val && root.val <= p.val)
                return root;
            else if (root.val > p.val && root.val > q.val)
                return lowestCommonAncestor(root.left, p, q);
            else
                return lowestCommonAncestor(root.right, p, q);
        }
    }

    class Solution_Iterative {
        // TC - O(h)
        // SC - O(1)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (root.val >= p.val && root.val <= q.val || root.val >= q.val && root.val <= p.val)
                    return root;
                else if (root.val > p.val && root.val > q.val)
                    root = root.left;
                else
                    root = root.right;
            }

            return root;
        }
    }
}
