package main.cp.leetcode._2021._05_may;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 25/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=ZDwyf-sirgw
 */
public class Day_25_150_Evaluate_Reverse_Polish_Notation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack();
            for (String t : tokens) {
                if ("+-*/".contains(t))
                    st.push(eval(st.pop(), st.pop(), t));
                else
                    st.push(Integer.parseInt(t));
            }

            return st.pop();
        }

        private int eval(int b, int a, String op) {
            if ("+".equals(op))
                return a + b;
            else if ("-".equals(op))
                return a - b;
            else if ("*".equals(op))
                return a * b;
            else
                return a / b;
        }
    }

    // Python Code

    /*
    class Solution:
        def evalRPN(self, tokens: List[str]) -> int:
        def eval(b, a, op):
                if op == "+":
                return a + b
        elif op == "-":
                return a - b
        elif op == "*":
                return a * b
                else:
                        return int(a / b)

        st = []
                for t in tokens:
                if t in "+*-/":
                st.append(eval(st.pop(), st.pop(), t))
                else:
                st.append(int(t))

                return st.pop()
    */
}
