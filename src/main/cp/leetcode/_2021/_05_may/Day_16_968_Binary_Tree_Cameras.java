package main.cp.leetcode._2021._05_may;

import main.cp.leetcode.TreeNode;

/**
 * Created by Naresh Gupta on 17/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=1OZKcD-JxwQ
 */
public class Day_16_968_Binary_Tree_Cameras {
    class Solution {
        private int COVERED = 0, PLEASE_COVER = 1, HAS_CAMERA = 2;

        private int camera = 0;

        public int minCameraCover(TreeNode root) {
            return postorder(root) == PLEASE_COVER ? ++camera : camera;
        }

        private int postorder(TreeNode root) {
            if (root == null)
                return COVERED;

            int left = postorder(root.left);
            int right = postorder(root.right);

            if (left == PLEASE_COVER || right == PLEASE_COVER) {
                camera++;
                return HAS_CAMERA;
            } else if (left == HAS_CAMERA || right == HAS_CAMERA) {
                return COVERED;
            } else {
                return PLEASE_COVER;
            }
        }
    }
}
