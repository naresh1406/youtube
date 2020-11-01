package main.cp.leetcode.november;

import main.cp.leetcode.ListNode;

import java.util.Stack;

/**
 * Created by Naresh Gupta on 1/11/2020 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=AnK8Fbu01t8
 */
public class Day_01_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer {
    // Iterative

    class Solution {
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while (head != null) {
                num = num * 2 + head.val; // num = num << 1 | head.val;
                head = head.next;
            }
            return num;
        }
    }

    // Recursive

    class Solution2 {
        public int getDecimalValue(ListNode head) {
            return recursive(head, 0);
        }

        private int recursive(ListNode head, int num) {
            return head == null ? num : recursive(head.next, 2 * num + head.val);
        }
    }

    // Stack

    class Solution3 {
        public int getDecimalValue(ListNode head) {
            Stack<Integer> st = new Stack();
            while (head != null) {
                st.add(head.val);
                head = head.next;
            }
            int factor = 1, num = 0;
            while (st.size() > 0) {
                num += st.pop() * factor;
                factor *= 2;
            }
            return num;
        }
    }
}
