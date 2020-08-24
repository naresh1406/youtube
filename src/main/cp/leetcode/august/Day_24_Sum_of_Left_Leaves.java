package main.cp.leetcode.august;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day_24_Sum_of_Left_Leaves {
    // 1. Recursive DFS
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null)
                return 0;
            if (root.left != null && root.left.left == null && root.left.right == null)
                return root.left.val + sumOfLeftLeaves(root.right);
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    // 2. Iterative Level Order Traversal (BFS)
    class Solution2 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);

            int sum = 0;
            while (queue.size() > 0) {
                root = queue.poll();
                if (root.left != null) {
                    if (root.left.left == null && root.left.right == null)
                        sum += root.left.val;
                    else queue.add(root.left);
                }
                if (root.right != null)
                    queue.add(root.right);
            }

            return sum;
        }
    }

    // 3. 1 Liner
    class Solution3 {
        public int sumOfLeftLeaves(TreeNode root) {
            return root == null ? 0 : root.left != null && root.left.left == null && root.left.right == null ? root.left.val + sumOfLeftLeaves(root.right) : sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
