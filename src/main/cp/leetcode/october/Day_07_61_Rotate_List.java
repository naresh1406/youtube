package main.cp.leetcode.october;

import main.cp.leetcode.ListNode;

public class Day_07_61_Rotate_List {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) // check base cases if head null or we have to rotate right 0 nodes
                return head;
            int length = 0;
            ListNode tail = head;
            while (tail.next != null) { // count the number of nodes and reach to the tail of list
                length++;
                tail = tail.next;
            }
            length++; // count tail node
            tail.next = head; // join tail with head
            int rotatePoint = length - k % length; //
            tail = head;
            while (rotatePoint-- > 1)
                tail = tail.next;
            head = tail.next;
            tail.next = null;
            return head;
        }
    }
}
