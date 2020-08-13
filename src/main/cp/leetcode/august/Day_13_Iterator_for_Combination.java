package main.cp.leetcode.august;

import java.util.LinkedList;
import java.util.Queue;

public class Day_13_Iterator_for_Combination {
    class CombinationIterator {

        Queue<String> queue;

        public CombinationIterator(String characters, int combinationLength) {
            queue = new LinkedList();
            combinations(characters, 0, "", combinationLength, queue);
        }

        public void combinations(String characters, int start, String soFar, int k, Queue<String> queue) {
            if (k == 0) {
                queue.add(soFar);
                return;
            }

            for (int i = start; i < characters.length(); i++) {
                combinations(characters, i + 1, soFar + characters.charAt(i), k - 1, queue);
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
}
