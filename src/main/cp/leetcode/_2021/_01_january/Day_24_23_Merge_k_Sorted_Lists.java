package main.cp.leetcode._2021._01_january;

import main.cp.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Naresh Gupta on 27/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/8-VNsOb19Bk?t=0
 */
public class Day_24_23_Merge_k_Sorted_Lists {
    // Solution 1 - Best Solution - Using MinHeap / PriorityQueue
    // TC - (NLogk)
    // SC - (1)

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((ln1, ln2) -> ln1.val - ln2.val);
            for (ListNode list : lists)
                if (list != null)
                    pq.add(list);

            ListNode dummy = new ListNode(-1), current = dummy;
            while (pq.size() > 0) {
                current.next = pq.poll();
                current = current.next;
                if (current.next != null)
                    pq.add(current.next);
            }

            return dummy.next;
        }
    }

    // Solution 2: Using Integer List sort and Construct Result List
    // TC - (NLogN)
    // SC - (N)

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            java.util.List<Integer> l = new ArrayList<Integer>();

            for (ListNode list : lists) {
                while (list != null) {
                    l.add(list.val);
                    list = list.next;
                }
            }

            Collections.sort(l);

            ListNode dummy = new ListNode(-1), current = dummy;
            for (int i : l)
                current = current.next = new ListNode(i);
            current.next = null;

            return dummy.next;
        }
    }

    // Solution 3: One by One merge list using mergeTwoLists
    // TC -(kN)
    // SC -(1)

    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0)
                return null;

            ListNode resultHead = lists[0];
            for (int i = 1; i < lists.length; i++)
                resultHead = mergeTwoLists(resultHead, lists[i]);

            return resultHead;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1), current = dummy;
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

            return dummy.next;
        }
    }
}
