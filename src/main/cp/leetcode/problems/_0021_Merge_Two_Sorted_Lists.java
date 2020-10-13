package main.cp.leetcode.problems;

import main.cp.leetcode.ListNode;

public class _0021_Merge_Two_Sorted_Lists {
    class Solution {
        // TC - O(n + m)
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

            if (l1 != null) current.next = l1;
            if (l2 != null) current.next = l2;

            return dummyHead.next;
        }
    }
}
