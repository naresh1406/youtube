package main.cp.leetcode.problems;

import main.cp.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0337_House_Robber_III {
    class Solution {
        Map<TreeNode, Integer> map = new HashMap();

        public int rob(TreeNode root) {
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);
            int val = 0;
            if (root.left != null) val += rob(root.left.left) + rob(root.left.right);
            if (root.right != null) val += rob(root.right.left) + rob(root.right.right);

            map.put(root, Math.max(root.val + val, rob(root.left) + rob(root.right)));
            return map.get(root);
        }
    }

    class Solution2 {
        public int rob(TreeNode root) {
            int[] result = robSub(root);
            return Math.max(result[0], result[1]);
        }

        private int[] robSub(TreeNode root) {
            if (root == null)
                return new int[2];

            int[] left = robSub(root.left);
            int[] right = robSub(root.right);
            int[] result = new int[2];

            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = root.val + left[0] + right[0];

            return result;
        }
    }
}
