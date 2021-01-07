package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 8/1/2021 AD.
 */
public class Day_05_82_Remove_Duplicates_from_Sorted_List_II {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummyHead = new ListNode(-1), dummy = dummyHead;
            while (head != null) {
                ListNode start = head;
                int count = 0;
                while (head != null && start.val == head.val) {
                    head = head.next;
                    count++;
                }
                if (count > 1) {
                    start = head;
                } else {
                    dummy.next = start;
                    dummy = dummy.next;
                }
            }
            dummy.next = null;

            return dummyHead.next;
        }
    }
}
