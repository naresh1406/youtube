package main.cp.leetcode.december;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 24/12/2020 AD.
 */
public class Day_24_24_Swap_Nodes_in_Pairs {
    class Solution {
        // TC - O(n)
        // SC - O(1)
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(-1), prev = dummy, current = head;
            dummy.next = head;
            while (current != null && current.next != null) {
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = current;
                current = current.next;
                prev = prev.next.next;
            }

            return dummy.next;
        }
    }
}
