package main.cp.leetcode._2021._04_april;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 22/4/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=0U3HYMgxbWc
 */
public class Day_14_86_Partition_List {
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
