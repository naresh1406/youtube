package main.cp.leetcode._2021._05_may;

import main.cp.leetcode.ListNode;
import main.cp.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 6/5/2021 AD.
 * Detailed Video Explanation - https://youtu.be/7WQgDC8LEh0
 */
public class Day_06_109_Convert_Sorted_List_to_Binary_Search_Tree {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;

            ListNode middle = middleNode(head);
            TreeNode root = new TreeNode(middle.val);
            if (middle == head)
                return root;

            root.left = sortedListToBST(head);
            root.right = sortedListToBST(middle.next);

            return root;
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head, prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            if (prev != null)
                prev.next = null;

            return slow;
        }
    }

    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> list = new ArrayList();
            for (; head != null; head = head.next)
                list.add(head.val);

            return dfs(list, 0, list.size() - 1);
        }

        private TreeNode dfs(List<Integer> list, int l, int r) {
            if (l > r)
                return null;

            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(list.get(mid));

            root.left = dfs(list, l, mid - 1);
            root.right = dfs(list, mid + 1, r);

            return root;
        }
    }

}
