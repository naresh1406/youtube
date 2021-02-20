package main.cp.leetcode._2021._02_february;

/**
 * Created by Naresh Gupta on 21/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=I-6YUQs-yCY
 */
public class Day_19_1249_Minimum_Remove_to_Make_Valid_Parentheses {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            // Stack<Integer> stack = new Stack();
            int open = 0;
            char ch[] = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '(') {
                    open++;
                } else if (ch[i] == ')') {
                    if (open == 0) {
                        ch[i] = '*';
                    } else {
                        open--;
                    }
                }
            }

            // while(!stack.isEmpty()) {
            //     ch[stack.pop()] = '*';
            // }

            for (int i = ch.length - 1; i >= 0; i--) {
                if (ch[i] == '(' && open > 0) {
                    ch[i] = '*';
                    open--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] != '*') {
                    sb.append(ch[i]);
                }
            }

            return sb.toString();
        }
    }
}
