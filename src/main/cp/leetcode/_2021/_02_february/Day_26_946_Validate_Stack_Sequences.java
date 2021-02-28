package main.cp.leetcode._2021._02_february;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 28/2/2021 AD.
 */
public class Day_26_946_Validate_Stack_Sequences {
    // With Stack, TC - O(n), SC - O(n)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int j = 0;
            Stack<Integer> st = new Stack();

            for (int x : pushed) {
                st.push(x);
                while (st.size() > 0 && st.peek() == popped[j]) {
                    st.pop();
                    j++;
                }
            }

            return st.isEmpty();
        }
    }

    // Without Stack, TC - O(n), SC - O(1)
    class Solution2 {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int i = 0, j = 0;
            for (int x : pushed) {
                pushed[i++] = x;
                while (i > 0 && pushed[i - 1] == popped[j]) {
                    i--;
                    j++;
                }
            }

            return i == 0;
        }
    }
}
