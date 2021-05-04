package main.cp.leetcode.problems;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by Naresh Gupta on 4/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=EWDd8fHnXL4
 */
public class _1845_Seat_Reservation_Manager {
    class SeatManager_Using_Array {

        private boolean[] seats;

        public SeatManager_Using_Array(int n) {
            seats = new boolean[n + 1];
        }

        public int reserve() {
            for (int i = 1; i <= seats.length; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    return i;
                }
            }

            return -1;
        }

        public void unreserve(int seatNumber) {
            seats[seatNumber] = false;
        }
    }

    class SeatManager_Using_MinHeap {

        private PriorityQueue<Integer> seats;

        public SeatManager_Using_MinHeap(int n) {
            seats = new PriorityQueue();
            for (int i = 1; i <= n; i++) {
                seats.add(i);
            }
        }

        public int reserve() {
            return seats.poll();
        }

        public void unreserve(int seatNumber) {
            seats.add(seatNumber);
        }
    }

    class SeatManager_Using_TreeSet {

        private TreeSet<Integer> seats;

        public SeatManager_Using_TreeSet(int n) {
            seats = new TreeSet();
            for (int i = 1; i <= n; i++) {
                seats.add(i);
            }
        }

        public int reserve() {
            return seats.pollFirst();
        }

        public void unreserve(int seatNumber) {
            seats.add(seatNumber);
        }
    }
}
