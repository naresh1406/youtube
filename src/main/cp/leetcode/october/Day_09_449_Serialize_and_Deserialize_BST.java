package main.cp.leetcode.october;

import main.cp.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Detailed Video Explanation - https://www.youtube.com/watch?v=lP2yP8Iy88c
 */

public class Day_09_449_Serialize_and_Deserialize_BST {

    // DFS preorder traversal

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString().trim();
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val + " ");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] s = data.split(" ");
            return constructBST(s, 0, s.length - 1);
        }

        private TreeNode constructBST(String[] s, int start, int end) {
            if (start > end) return null;
            TreeNode root = new TreeNode(Integer.parseInt(s[start]));

            int index;
            for (index = start; index <= end; index++) {
                if (Integer.parseInt(s[index]) > Integer.parseInt(s[start]))
                    break;
            }

            root.left = constructBST(s, start + 1, index - 1);
            root.right = constructBST(s, index, end);

            return root;
        }
    }

    // BFS

    public class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder("");

            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            while (q.size() > 0) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("n ");
                    continue;
                }
                sb.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "") return null;
            String[] s = data.split(" ");

            TreeNode root = new TreeNode(Integer.parseInt(s[0]));

            Queue<TreeNode> q = new LinkedList();
            q.add(root);

            for (int i = 1; i < s.length; i++) {
                TreeNode parent = q.poll();
                if (!s[i].equals("n")) {
                    parent.left = new TreeNode(Integer.parseInt(s[i]));
                    q.add(parent.left);
                }
                i++;
                if (i < s.length && !s[i].equals("n")) {
                    parent.right = new TreeNode(Integer.parseInt(s[i]));
                    q.add(parent.right);
                }
            }

            return root;
        }
    }
}
