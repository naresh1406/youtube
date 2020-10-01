package main.cp.leetcode.october;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Day_01_933_Number_of_Recent_Calls {
    // Queue
    class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    // TreeSet
    class RecentCounter2 {

        TreeSet<Integer> treeSet;

        public RecentCounter2() {
            treeSet = new TreeSet();
        }

        public int ping(int t) {
            treeSet.add(t);
            return treeSet.tailSet(t - 3000).size();
        }
    }
}
