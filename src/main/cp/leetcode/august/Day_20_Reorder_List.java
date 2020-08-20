package main.cp.leetcode.august;

import main.cp.leetcode.ListNode;

import java.util.Stack;

public class Day_20_Reorder_List {
    // 2. Without Stack
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;

            // 1. Middle of the list
            ListNode slow = head, fast = slow.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2. Reverse Second Half List
            ListNode preMiddle = slow;
            ListNode preCurrent = slow.next;
            while (preCurrent.next != null) {
                ListNode current = preCurrent.next;
                preCurrent.next = current.next;
                current.next = preMiddle.next;
                preMiddle.next = current;
            }

            // 3. Merge Alternate Nodes
            slow = head;
            fast = preMiddle.next;
            while (slow != preMiddle) {
                preMiddle.next = fast.next;
                fast.next = slow.next;
                slow.next = fast;
                slow = fast.next;
                fast = preMiddle.next;
            }
        }
    }

    // 2. With Stack
    class Solution2 {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;

            // 1. Middle of the list
            ListNode slow = head, fast = slow.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2. Add Second Half list nodes in Stack
            Stack<ListNode> stack = new Stack();
            ListNode current = slow.next;
            slow.next = null;
            while (current != null) {
                stack.push(current);
                current = current.next;
            }

            // 3. Merge Stack Nodes in first half Alternate Nodes
            current = head;
            while (stack.size() > 0) {
                stack.peek().next = current.next;
                current.next = stack.pop();
                current = current.next.next;
            }
        }
    }
}
