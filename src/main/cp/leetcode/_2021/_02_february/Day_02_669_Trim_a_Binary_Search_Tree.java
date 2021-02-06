package main.cp.leetcode._2021._02_february;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 3/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=5JU-pACoAJg
 */
public class Day_02_669_Trim_a_Binary_Search_Tree {
    // TC - O(n)
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null)
                return null;
            if (root.val < low)
                return trimBST(root.right, low, high);
            if (root.val > high)
                return trimBST(root.left, low, high);
            root.left = trimBST(root.left, low, root.val - 1);
            root.right = trimBST(root.right, root.val + 1, high);

            return root;
        }
    }
}
