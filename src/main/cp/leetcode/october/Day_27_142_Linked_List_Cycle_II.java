package main.cp.leetcode.october;

import main.cp.leetcode.ListNode;

public class Day_27_142_Linked_List_Cycle_II {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }

                    return slow;
                }
            }

            return null;
        }
    }
}
