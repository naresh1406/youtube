package main.cp.leetcode.problems;

import java.util.Stack;

public class _0155_Min_Stack {
    // 1. Two Stack
    class MinStack {

        /**
         * initialize your data structure here.
         */
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public void push(int x) {
            stack.push(x);
            int min = minStack.size() > 0 ? Math.min(x, minStack.peek()) : x;
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    // 2. One Stack
    class MinStack2 {

        /**
         * initialize your data structure here.
         */
        private Stack<int[]> stack;

        public MinStack2() {
            stack = new Stack();
        }

        public void push(int x) {
            int min = stack.size() > 0 ? Math.min(x, stack.peek()[1]) : x;
            stack.push(new int[]{x, min});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

    // 3. One Stack + min Variable
    class MinStack3 {

        /**
         * initialize your data structure here.
         */
        private Stack<Integer> stack;
        private int min;

        public MinStack3() {
            stack = new Stack();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == min)
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    // 4. No Stack with Node
    class MinStack4 {

        /**
         * initialize your data structure here.
         */
        class Node {
            int val;
            int min;
            Node next;

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head;

        public MinStack4() {
            head = null;
        }

        public void push(int x) {
            head = head == null ? new Node(x, x, null) : new Node(x, Math.min(x, head.min), head);
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
