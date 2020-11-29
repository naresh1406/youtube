package main.cp.leetcode.problems;

import java.util.LinkedList;

/**
 * Created by Naresh Gupta on 29/11/2020 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=3917JWFmleo
 */
public class _1670_Design_Front_Middle_Back_Queue {
    class FrontMiddleBackQueue {

        LinkedList<Integer> q;

        public FrontMiddleBackQueue() {
            q = new LinkedList();
        }

        public void pushFront(int val) {
            q.addFirst(val);
        }

        public void pushMiddle(int val) {
            q.add(q.size() / 2, val);
        }

        public void pushBack(int val) {
            q.addLast(val);
        }

        public int popFront() {
            return q.isEmpty() ? -1 : q.removeFirst();
        }

        public int popMiddle() {
            return q.isEmpty() ? -1 : q.remove((q.size() - 1) / 2);
        }

        public int popBack() {
            return q.isEmpty() ? -1 : q.removeLast();
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}
