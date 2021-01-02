package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 2/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=SUi0WlbekkE
 */
public class Day_02_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
    // DFS

    class Inorder {
        TreeNode clonedTarget = null;

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            dfs(cloned, target.val);
            return clonedTarget;
        }

        private void dfs(TreeNode root, int v) {
            if (root == null)
                return;
            dfs(root.left, v);
            if (root.val == v)
                clonedTarget = root;
            dfs(root.right, v);
        }
    }

    class Preorder {
        TreeNode clonedTarget = null;

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            dfs(cloned, target.val);
            return clonedTarget;
        }

        private void dfs(TreeNode root, int v) {
            if (root == null)
                return;
            if (root.val == v)
                clonedTarget = root;
            dfs(root.left, v);
            dfs(root.right, v);
        }
    }

    class Postorder {
        TreeNode clonedTarget = null;

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            dfs(cloned, target.val);
            return clonedTarget;
        }

        private void dfs(TreeNode root, int v) {
            if (root == null)
                return;
            dfs(root.left, v);
            dfs(root.right, v);
            if (root.val == v)
                clonedTarget = root;
        }
    }

    // BFS

    class LevelOrder {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            TreeNode root = cloned;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (queue.size() > 0) {
                root = queue.poll();
                if (root.val == target.val)
                    return root;
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
            }
            return null;
        }
    }

    class FollowUp {
        // Pair class in available after Java-8 only
        class Pair<T> {
            T key;
            T value;

            public Pair(T key, T value) {
                this.key = key;
                this.value = value;
            }

            public T getKey() {
                return key;
            }

            public T getValue() {
                return value;
            }
        }

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            TreeNode rootOriginal = original;
            TreeNode rootCloned = cloned;
            Queue<Pair<TreeNode>> queue = new LinkedList();
            queue.add(new Pair(rootOriginal, rootCloned));
            while (queue.size() > 0) {
                Pair<TreeNode> pair = queue.poll();
                rootOriginal = pair.getKey();
                rootCloned = pair.getValue();
                if (rootOriginal == target)
                    return rootCloned;
                if (rootOriginal.left != null)
                    queue.add(new Pair(rootOriginal.left, rootCloned.left));
                if (rootOriginal.right != null)
                    queue.add(new Pair(rootOriginal.right, rootCloned.right));
            }
            return null;
        }
    }

}
