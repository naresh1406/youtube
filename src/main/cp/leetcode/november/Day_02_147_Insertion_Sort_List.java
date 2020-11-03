package main.cp.leetcode.november;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 3/11/2020 AD.
 */
public class Day_02_147_Insertion_Sort_List {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(-1), curr = head;

            while (curr != null) {
                ListNode temp = curr.next;
                ListNode prev = dummy;
                ListNode nxt = dummy.next;

                while (nxt != null) {
                    if (nxt.val > curr.val)
                        break;
                    prev = nxt;
                    nxt = nxt.next;
                }

                curr.next = nxt;
                prev.next = curr;
                curr = temp;
            }

            return dummy.next;
        }
    }
}
