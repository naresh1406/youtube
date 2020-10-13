package main.cp.leetcode.october;

import main.cp.leetcode.ListNode;

public class Day_13_148_Sort_List {
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode mid = middleNode(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return mergeTwoLists(left, right);
        }

        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head, mid;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            mid = slow.next;
            slow.next = null;
            return mid;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1), current = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            current.next = l1 != null ? l1 : l2;
            return dummyHead.next;
        }
    }

    // Selection Sort

    class Solution2 {
        public ListNode sortList(ListNode head) {
            if (head == null) return head;
            ListNode current = head;
            while (current != null) {
                ListNode iter = current;
                ListNode min = iter;
                while (iter != null) {
                    if (iter.val < min.val)
                        min = iter;
                    iter = iter.next;
                }
                int temp = current.val;
                current.val = min.val;
                min.val = temp;
                current = current.next;
            }
            return head;
        }
    }
}
