package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 12/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/_jm-KKZE9x8?t=0
 */
public class Day_12_2_Add_Two_Numbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode l = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                l.next = new ListNode(sum % 10);
                l = l.next;
                carry = sum / 10;
            }

            if (carry != 0)
                l.next = new ListNode(carry);

            return dummyHead.next;
        }
    }
}
