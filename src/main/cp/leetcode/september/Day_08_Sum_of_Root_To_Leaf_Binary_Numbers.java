package main.cp.leetcode.september;

import main.cp.leetcode.TreeNode;

public class Day_08_Sum_of_Root_To_Leaf_Binary_Numbers {
    // 1. Recursive
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int sum) {
            if (root == null)
                return 0;
            sum = sum * 2 + root.val; // sum = (sum << 1) + root.val;
            return (root.left == null && root.right == null) ? sum : dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    // 2. Iterative
    /*
    class Solution {
        public int sumRootToLeaf(TreeNode root) {
            if (root == null)
                return 0;
            Stack<Pair<TreeNode, Integer>> stack = new Stack();
            stack.push(new Pair(root, 0));
            int sum = 0, currNumber;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> p = stack.pop();
                root = p.getKey();
                currNumber = p.getValue();
                currNumber = currNumber * 2 + root.val;
                if (root.left == null && root.right == null)
                    sum += currNumber;
                if (root.right != null)
                    stack.push(new Pair(root.right, currNumber));
                if (root.left != null)
                    stack.push(new Pair(root.left, currNumber))
            }
            return sum;
        }
    }
    */
}
