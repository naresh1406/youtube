package main.cp.leetcode._2021._05_may;

import main.cp.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Naresh Gupta on 21/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=_Xy2RX1kHww
 */
public class Day_20_102_Binary_Tree_Level_Order_Traversal {
    class Solution_Iterative {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList();
            if (root == null)
                return result;

            Queue<TreeNode> q = new LinkedList();
            q.offer(root);

            while (q.size() > 0) {
                int size = q.size();
                List<Integer> level = new ArrayList();
                while (size-- > 0) {
                    root = q.poll();
                    level.add(root.val);
                    if (root.left != null)
                        q.add(root.left);
                    if (root.right != null)
                        q.add(root.right);
                }
                result.add(level);
            }

            return result;
        }
    }

    class Solution_Recursive {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap();
            dfs(root, 0, map);
            return new ArrayList(map.values());
        }

        private void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map) {
            if (node == null)
                return;
            map.computeIfAbsent(level, l -> new ArrayList()).add(node.val);
            dfs(node.left, level + 1, map);
            dfs(node.right, level + 1, map);
        }
    }
}
