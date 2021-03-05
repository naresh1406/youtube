package main.cp.leetcode._2021._03_march;

import main.cp.leetcode.ListNode;

/**
 * Created by Naresh Gupta on 5/3/2021 AD.
 */
public class Day_04_160_Intersection_of_Two_Linked_Lists {
    // TC - O(N + M), SC - O(1)
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }

            return pA;
        }
    }

    // TC - O(N + M), SC - O(1)
    public class Solution2 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int m = lengthOfList(headA);
            int n = lengthOfList(headB);

            while (m > n) {
                headA = headA.next;
                m--;
            }

            while (n > m) {
                headB = headB.next;
                n--;
            }

            while (headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }

        private int lengthOfList(ListNode head) {
            int len = 0;
            while (head != null) {
                head = head.next;
                len++;
            }

            return len;
        }
    }

    // Brute Force or Naive
    // TC - O(N * M), SC - O(1)
    public class Solution3 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            while(headA != null) {
                ListNode pB = headB;
                while(pB != null) {
                    if(headA == pB)
                        return pB;
                    pB = pB.next;
                }
                headA = headA.next;
            }

            return null;
        }
    }
}
