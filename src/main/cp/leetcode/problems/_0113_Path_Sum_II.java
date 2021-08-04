package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 4/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=mS-CFA_k1yM
 */
public class _0113_Path_Sum_II {
    class Solution_1 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList();
            pathSum(root, targetSum, new ArrayList(), result);
            return result;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
            if (root == null)
                return;
            path.add(root.val);
            if (root.left == null && root.right == null && sum == root.val)
                result.add(path);
            pathSum(root.left, sum - root.val, new ArrayList(path), result);
            pathSum(root.right, sum - root.val, new ArrayList(path), result);
        }
    }

    class Solution_2 {
        // TC - O(N^2)
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList();
            pathSum(root, targetSum, new ArrayList(), result);
            return result;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
            if (root == null)
                return;
            path.add(root.val);
            if (root.left == null && root.right == null && sum == root.val)
                result.add(new ArrayList(path));
            pathSum(root.left, sum - root.val, path, result);
            pathSum(root.right, sum - root.val, path, result);
            path.remove(path.size() - 1);
        }
    }
}
