package main.cp.leetcode.july;

import main.cp.leetcode.ListNode;

/**
 * Day_20_Remove_Linked_List_Elements
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
 */
public class Day_20_Remove_Linked_List_Elements {
    // 1. With dummy head
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyNode = new ListNode(-1);
            dummyNode.next = head;
            ListNode prev = dummyNode;

            while (head != null) {
                if (head.val != val) {
                    prev.next = head;
                    prev = prev.next;
                }
                head = head.next;
            }
            prev.next = null;
            return dummyNode.next;
        }
    }

    // 2. Without dummy head
    class Solution2 {
        // TC - O(N)
        // SC - O(1)
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) head = head.next;
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.next.val == val)
                    current.next = current.next.next;
                else current = current.next;
            }

            return head;
        }
    }

    // 3. Recursive
    class Solution3 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}