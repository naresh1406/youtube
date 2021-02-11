package main.cp.leetcode._2021._02_february;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 11/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Jo4Oko5Y6T
 */
public class Day_10_138_Copy_List_with_Random_Pointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // O(N) time and O(N) Extra Space

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap();

            Node dummyHead = new Node(-1);
            Node current = head, copy = dummyHead;

            while (current != null) {
                copy.next = new Node(current.val);
                copy = copy.next;
                map.put(current, copy);
                current = current.next;
            }

            current = head;
            copy = dummyHead.next;

            while (current != null) {
                copy.random = map.get(current.random);
                copy = copy.next;
                current = current.next;
            }

            return dummyHead.next;
        }
    }

    // O(N) time and O(1) Extra Space

    class Solution2 {
        public Node copyRandomList(Node head) {
            Node current = head;

            while(current != null) {
                Node copy = new Node(current.val);
                copy.next = current.next;
                current.next = copy;
                current = current.next.next;
            }

            current = head;
            while(current != null) {
                current.next.random = current.random == null ? null : current.random.next;
                current = current.next.next;
            }

            Node dummyHead = new Node(-1);
            Node dummy = dummyHead;
            current = head;

            while(current != null) {
                dummy.next = current.next;
                dummy = dummy.next;
                current.next = current.next.next;
                current = current.next;
            }

            return dummyHead.next;
        }
    }
}
