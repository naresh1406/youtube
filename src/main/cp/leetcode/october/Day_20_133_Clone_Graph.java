package main.cp.leetcode.october;

import java.util.*;

public class Day_20_133_Clone_Graph {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // DFS
    class Solution {
        private Map<Node, Node> map = new HashMap();

        public Node cloneGraph(Node node) {
            if (node == null)
                return null;
            if (map.containsKey(node))
                return map.get(node);
            Node root = new Node(node.val);
            map.put(node, root);
            for (Node ng : node.neighbors)
                root.neighbors.add(cloneGraph(ng));
            return root;
        }
    }

    // BFS
    class Solution2 {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            Map<Node, Node> map = new HashMap<Node, Node>();
            map.put(node, new Node(node.val));
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                for (Node neighbor : current.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    map.get(current).neighbors.add(map.get(neighbor));
                }
            }

            return map.get(node);
        }
    }
}
