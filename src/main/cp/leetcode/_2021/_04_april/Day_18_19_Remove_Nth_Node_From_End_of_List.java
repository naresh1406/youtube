package main.cp.leetcode._2021._04_april;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 22/4/2021 AD.
 * Detailed Video Explanation https://youtu.be/9wRw-Bu_q-w?t=0
 */
public class Day_18_19_Remove_Nth_Node_From_End_of_List {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;

            while (n-- >= 0)
                first = first.next;

            while (first != null) {
                first = first.next;
                second = second.next;
            }

            second.next = second.next.next;

            return dummy.next;
        }
    }
}
