package main.cp.leetcode.december;

import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naresh Gupta on 29/12/2020 AD.
 */
public class Day_29_1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree {
    class Solution {
        int count = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            dfs(root, new ArrayList());
            return count;
        }

        private void dfs(TreeNode root, List<Integer> path) {
            if (root == null)
                return;
            List<Integer> newPath = new ArrayList(path);
            newPath.add(root.val);
            if (root.left == null && root.right == null) {
                count += isPseudoPalindromicPaths(newPath) ? 1 : 0;
                return;
            }
            dfs(root.left, newPath);
            dfs(root.right, newPath);
        }

        private boolean isPseudoPalindromicPaths(List<Integer> path) {
            int[] frequency = new int[10];
            for (int i : path)
                frequency[i]++;
            return Arrays.stream(frequency).filter(x -> x % 2 == 1).count() <= 1;
        }
    }

    class Solution2 {
        int count = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            dfs(root, 0);
            return count;
        }

        private void dfs(TreeNode root, int path) {
            if (root == null)
                return;
            path = path ^ (1 << root.val);
            if (root.left == null && root.right == null) {
                // count += Integer.bitCount(path) <= 1 ? 1 : 0;
                count += (path & (path - 1)) == 0 ? 1 : 0; // check if number of set bit is <= 1
                return;
            }
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}
