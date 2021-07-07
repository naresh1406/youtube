package main.cp.leetcode.problems;

import java.util.Stack;

public class _1047_Remove_All_Adjacent_Duplicates_In_String {
    // Using Stack
    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> st = new Stack();
            for (char c : s.toCharArray()) {
                if (st.size() > 0 && st.peek() == c)
                    st.pop();
                else
                    st.push(c);
            }

            StringBuilder sb = new StringBuilder();
            while (st.size() > 0)
                sb.append(st.pop());

            return sb.reverse().toString();
        }
    }

    // StringBuilder as Stack
    class Solution_2 {
        public String removeDuplicates(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c)
                    sb.deleteCharAt(sb.length() - 1);
                else
                    sb.append(c);
            }

            return sb.toString();
        }
    }
}
