package main.cp.leetcode.november;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 9/11/2020 AD.
 */
public class Day_08_563_Binary_Tree_Tilt {
    class Solution {
        int result = 0;

        public int findTilt(TreeNode root) {
            tilt(root);
            return result;
        }

        private int tilt(TreeNode root) {
            if (root == null)
                return 0;
            int leftSum = tilt(root.left);
            int rightSum = tilt(root.right);
            result += Math.abs(leftSum - rightSum);
            return leftSum + rightSum + root.val;
        }
    }
}
