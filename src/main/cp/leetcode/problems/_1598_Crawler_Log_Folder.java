package main.cp.leetcode.problems;

public class _1598_Crawler_Log_Folder {
    class Solution {
        public int minOperations(String[] logs) {
            int depth = 0;
            for (String log : logs) {
                if (log.equals("./")) continue;
                else if (log.equals("../")) {
                    depth--;
                    if (depth < 0) depth = 0;
                } else depth++;
            }
            return depth;
        }
    }
}
