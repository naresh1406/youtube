package main.cp.leetcode._2021._02_february;

import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 7/2/2021 AD.
 * Detailed Video Explanation https://youtu.be/u1EHRt6Uxxk?t=0
 */
public class Day_06_199_Binary_Tree_Right_Side_View {

    // BFS O(N) time

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList();
            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (!q.isEmpty() && root != null) {
                result.add(q.peek().val);
                for (int i = q.size(); i > 0; i--) {
                    root = q.poll();
                    if (root.right != null)
                        q.add(root.right);
                    if (root.left != null)
                        q.add(root.left);
                }
            }

            return result;
        }
    }

    // DFS O(N) time

    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList();
            dfs(root, 0, list);
            return list;
        }

        private void dfs(TreeNode root, int d, List<Integer> list) {
            if (root == null)
                return;
            if (list.size() == d)
                list.add(root.val);
            dfs(root.right, d + 1, list);
            dfs(root.left, d + 1, list);
        }
    }
}
