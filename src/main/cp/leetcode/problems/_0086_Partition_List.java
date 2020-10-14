package main.cp.leetcode.problems;

import main.cp.leetcode.ListNode;

public class _0086_Partition_List {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smallerHead = new ListNode(0), smaller = smallerHead;
            ListNode biggerHead = new ListNode(0), bigger = biggerHead;
            while (head != null) {
                if (head.val < x) {
                    smaller.next = head;
                    smaller = smaller.next;
                } else {
                    bigger.next = head;
                    bigger = bigger.next;
                }
                head = head.next;
            }
            bigger.next = null;
            smaller.next = biggerHead.next;
            return smallerHead.next;
        }
    }
}
