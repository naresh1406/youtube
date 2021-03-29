package main.cp.leetcode._2021._03_march;

import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Naresh Gupta on 30/3/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=5_KZoLMGVRA
 */
public class Day_29_971_Flip_Binary_Tree_To_Match_Preorder_Traversal {
    // DFS Recursive
    class Solution {
        List<Integer> result = new ArrayList<>();
        int i = 0;

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            return dfs(root, voyage) ? result : Arrays.asList(-1);
        }

        public boolean dfs(TreeNode node, int[] A) {
            if (node == null)
                return true;
            if (node.val != A[i++])
                return false;

            if (node.left != null && node.left.val != A[i]) {
                result.add(node.val);
                return dfs(node.right, A) && dfs(node.left, A);
            }

            return dfs(node.left, A) && dfs(node.right, A);
        }
    }

    // DFS Iterative
    class Solution2 {
        public List<Integer> flipMatchVoyage(TreeNode root, int[] A) {
            List<Integer> result = new ArrayList();
            if (root == null)
                return result;
            Stack<TreeNode> stack = new Stack();
            stack.add(root);
            int i = 0;

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.val != A[i++])
                    return Arrays.asList(-1);
                if (node.right != null && node.right.val == A[i]) {
                    if (node.left != null) {
                        result.add(node.val);
                        stack.add(node.left);
                    }
                    stack.add(node.right);
                } else {
                    if (node.right != null)
                        stack.add(node.right);
                    if (node.left != null)
                        stack.add(node.left);
                }
            }

            return result;
        }
    }
}
