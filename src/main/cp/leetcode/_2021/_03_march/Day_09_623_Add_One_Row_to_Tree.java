package main.cp.leetcode._2021._03_march;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 10/3/2021 AD.
 * Detailed Video Solution - https://www.youtube.com/watch?v=c7sJI9jY9i4
 */
public class Day_09_623_Add_One_Row_to_Tree {

    // TC - O(n), SC - O(x)
    class Solution {
        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if (d == 1) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = root;
                return newRoot;
            }

            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (--d > 1) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }

            while (q.size() > 0) {
                TreeNode node = q.poll();
                TreeNode lst = node.left, rst = node.right;
                node.left = new TreeNode(v);
                node.right = new TreeNode(v);
                node.left.left = lst;
                node.right.right = rst;
            }

            return root;
        }
    }
}
