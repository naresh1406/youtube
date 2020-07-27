package main.cp.leetcode.july;

import main.cp.leetcode.TreeNode;

import java.util.*;

/**
 * Day_22_Binary_Tree_Zigzag_Level_Order_Traversal
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/
 */
public class Day_22_Binary_Tree_Zigzag_Level_Order_Traversal {
    // 1. BFS, Level Order with Flag
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null) return new ArrayList();
            List<List<Integer>> result = new ArrayList();
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            boolean reverseLevel = false;

            while(!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList();
                while(size-- > 0) {
                    root = q.poll();
                    level.add(root.val);
                    if(root.left != null) q.add(root.left);
                    if(root.right != null) q.add(root.right);
                }
                if(reverseLevel) Collections.reverse(level);
                result.add(level);
                reverseLevel = !reverseLevel;
            }

            return result;
        }
    }

    // 2. Two Stack Solution
    class Solution2 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();

            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.add(root);

            while (!s1.isEmpty() || !s2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!s1.isEmpty()) {
                    root = s1.pop();
                    list.add(root.val);
                    if (root.left != null) s2.add(root.left);
                    if (root.right != null) s2.add(root.right);
                }
                if (!list.isEmpty()) result.add(list);
                list = new ArrayList<>();
                while (!s2.isEmpty()) {
                    root = s2.pop();
                    list.add(root.val);
                    if (root.right != null) s1.add(root.right);
                    if (root.left != null) s1.add(root.left);
                }
                if (!list.isEmpty()) result.add(list);
            }

            return result;
        }
    }
}