package main.cp.leetcode.july;

import main.cp.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Day_27_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3403/
 */
public class Day_27_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    // 1. Without Map
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return constructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
        }

        private TreeNode constructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int index) {
            if (start > end) return null;
            TreeNode root = new TreeNode(postorder[index]);

            int inRootIndex = start;
            while (postorder[index] != inorder[inRootIndex]) inRootIndex++;

            root.right = constructTreeFromInPost(inorder, postorder, inRootIndex + 1, end, index - 1);
            root.left = constructTreeFromInPost(inorder, postorder, start, inRootIndex - 1, index - (end - inRootIndex) - 1);

            return root;
        }
    }

    // 1. With Map
    class Solution2 {
        Map<Integer, Integer> map = new HashMap();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++)
                map.put(inorder[i], i);
            return constructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
        }

        private TreeNode constructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int index) {
            if (start > end) return null;
            TreeNode root = new TreeNode(postorder[index]);

            int inRootIndex = map.get(postorder[index]);
            //while(postorder[index] != inorder[inRootIndex]) inRootIndex++;

            root.right = constructTreeFromInPost(inorder, postorder, inRootIndex + 1, end, index - 1);
            root.left = constructTreeFromInPost(inorder, postorder, start, inRootIndex - 1, index - (end - inRootIndex) - 1);

            return root;
        }
    }
}
