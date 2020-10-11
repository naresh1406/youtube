package main.cp.leetcode.october;

import java.util.Stack;

public class Day_11_316_Remove_Duplicate_Letters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] lastIndex = new int[26];
            for (int i = 0; i < s.length(); i++)
                lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
            boolean[] seen = new boolean[26]; // keep track seen
            Stack<Integer> st = new Stack();
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (seen[c]) continue; // if seen continue as we need to pick one char only
                while (!st.isEmpty() && st.peek() > c && i < lastIndex[st.peek()])
                    seen[st.pop()] = false; // pop out and mark unseen
                st.push(c); // add into stack
                seen[c] = true; // mark seen
            }

            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty())
                sb.append((char) (st.pop() + 'a'));
            return sb.reverse().toString();
        }
    }
}
