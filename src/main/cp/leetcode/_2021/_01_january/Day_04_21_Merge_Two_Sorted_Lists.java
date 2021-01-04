package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 4/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=0KAEBYaL2Oc
 */
public class Day_04_21_Merge_Two_Sorted_Lists {

    // Iterative

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

    // Recursive

    class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1), current = dummy;
            helper(l1, l2, current);
            return dummy.next;
        }

        public void helper(ListNode l1, ListNode l2, ListNode current) {
            if (l1 == null && l2 == null)
                return;
            if (l1 == null && l2 != null) {
                current.next = l2;
                return;
            } else if (l1 != null && l2 == null) {
                current.next = l1;
                return;
            } else if (l1.val < l2.val) {
                current.next = l1;
                helper(l1.next, l2, current.next);
            } else {
                current.next = l2;
                helper(l1, l2.next, current.next);
            }
        }
    }
}
