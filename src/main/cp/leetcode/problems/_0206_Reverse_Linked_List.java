package main.cp.leetcode.problems;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 8/9/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=3butB3RvKcY
 */
public class _0206_Reverse_Linked_List {
    class Solution_Recursive {
        public ListNode reverseList(ListNode head) {
            return helper(head, null);
        }

        private ListNode helper(ListNode head, ListNode prev) {
            if (head == null)
                return prev;
            ListNode next = head.next;
            head.next = prev;
            return helper(next, head);
        }
    }

    class Solution_Iterative {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }
    }
}
