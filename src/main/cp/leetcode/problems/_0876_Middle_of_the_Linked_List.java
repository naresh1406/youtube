package main.cp.leetcode.problems;

import main.cp.leetcode.ListNode;

/**
 * Detailed Video Explanation https://www.youtube.com/watch?v=W4EXWkiha6Y
 */
public class _0876_Middle_of_the_Linked_List {
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
