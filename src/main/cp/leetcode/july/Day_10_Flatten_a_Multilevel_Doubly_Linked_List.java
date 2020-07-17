package main.cp.leetcode.july;

import java.util.Stack;

/**
 * Day_10_Flatten_a_Multilevel_Doubly_Linked_List
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
 */
public class Day_10_Flatten_a_Multilevel_Doubly_Linked_List {
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    // 1. Without Stack
    class Solution {
        public Node flatten(Node head) {
            if (head == null) return head;
            Node current = head;
            while (current != null) {
                if (current.child == null) {
                    current = current.next;
                    continue;
                }
                Node temp = current.child;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = current.next;  // Connect child tail with current.next, if it is not null
                if (current.next != null)
                    current.next.prev = temp; // if current.next is not null then change the prev of current.next to temp
                // Connect node with current.child, and remove current.child make it null
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            return head;
        }
    }

    // 2. With Stack
    class Solution2 {
        public Node flatten(Node head) {
            Stack<Node> stack = new Stack<>();
            Node current = head;
            while (current != null || !stack.isEmpty()) {
                if (current.child != null) {
                    if (current.next != null) stack.push(current.next);
                    current.next = current.child;
                    current.next.prev = current;
                    current.child = null;
                } else {
                    if (current.next == null && !stack.isEmpty()) {
                        current.next = stack.pop();
                        current.next.prev = current;
                    }
                }
                current = current.next;
            }
            return head;
        }
    }
}
