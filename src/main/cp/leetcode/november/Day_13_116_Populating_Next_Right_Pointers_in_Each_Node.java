package main.cp.leetcode.november;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Naresh Gupta on 14/11/2020 AD.
 */
public class Day_13_116_Populating_Next_Right_Pointers_in_Each_Node {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return null;

            Queue<Node> q = new LinkedList();
            q.offer(root);

            while (q.size() > 0) {
                int size = q.size();
                Node prev = null;
                while (size-- > 0) {
                    Node node = q.poll();
                    node.next = prev;
                    prev = node;
                    if (node.right != null)
                        q.offer(node.right);
                    if (node.left != null)
                        q.offer(node.left);
                }
            }
            return root;
        }
    }

    // Constant Space

    class Solution2 {
        public Node connect(Node root) {
            if (root == null)
                return null;

            Node current = root;
            while (current.left != null) {
                Node temp = current;
                while (current != null) {
                    current.left.next = current.right;
                    current.right.next = current.next == null ? null : current.next.left;
                    current = current.next;
                }
                current = temp.left;
            }
            return root;
        }
    }
}
