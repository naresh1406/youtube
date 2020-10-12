package main.cp.leetcode.problems;

public class _1614_Maximum_Nesting_Depth_of_the_Parentheses {
    class Solution {
        public int maxDepth(String s) {
            int depth = 0, open = 0;
            for (char c : s.toCharArray()) {
                if (c == '(')
                    open++;
                if (c == ')')
                    open--;
                depth = Math.max(depth, open);
            }
            return depth;
        }
    }
}
