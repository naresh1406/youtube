package main.cp.leetcode.november;

import main.cp.leetcode.ListNode;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 8/11/2020 AD.
 */
public class Day_07_445_Add_Two_Numbers_II {
    // Reverse
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverseList(l1);
            l2 = reverseList(l2);
            return reverseList(addTwoNumbersUtil(l1, l2));
        }

        public ListNode addTwoNumbersUtil(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode current = dummyHead;

            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                current.next = new ListNode(sum % 10);
                current = current.next;
                carry = sum / 10;
            }

            return dummyHead.next;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }

    // Stack
    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = listToStack(l1);
            Stack<Integer> s2 = listToStack(l2);

            ListNode head = null;
            int carry = 0;
            while (s1.size() > 0 || s2.size() > 0 || carry != 0) {
                int sum = carry;
                if (s1.size() > 0) sum += s1.pop();
                if (s2.size() > 0) sum += s2.pop();
                ListNode newNode = new ListNode(sum % 10);
                newNode.next = head;
                head = newNode;
                carry = sum / 10;
            }

            return head;
        }

        private Stack<Integer> listToStack(ListNode l) {
            Stack<Integer> stack = new Stack();
            while (l != null) {
                stack.add(l.val);
                l = l.next;
            }
            return stack;
        }
    }
}
