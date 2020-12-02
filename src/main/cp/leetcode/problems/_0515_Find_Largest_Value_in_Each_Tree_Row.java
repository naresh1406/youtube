package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

import java.util.*;

/**
 * Created by Naresh Gupta on 2/12/2020 AD.
 */
public class _0515_Find_Largest_Value_in_Each_Tree_Row {
    // DFS
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            Map<Integer, Integer> map = new HashMap();
            dfs(root, 0, map);
            return new ArrayList(map.values());
        }

        private void dfs(TreeNode root, int level, Map<Integer, Integer> map) {
            if (root == null)
                return;
            map.put(level, Math.max(root.val, map.getOrDefault(level, Integer.MIN_VALUE)));
            dfs(root.left, level + 1, map);
            dfs(root.right, level + 1, map);
        }
    }

    // BFS
    class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int size = q.size();
                int max = Integer.MIN_VALUE;
                while (size-- > 0) {
                    TreeNode temp = q.poll();
                    max = Math.max(max, temp.val);
                    if (temp.left != null)
                        q.add(temp.left);
                    if (temp.right != null)
                        q.add(temp.right);
                }
                list.add(max);
            }
            return list;
        }
    }
}
