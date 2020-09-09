package main.cp.leetcode.september;

import java.util.LinkedList;
import java.util.Queue;

public class Day_08_Premium_Moving_Average_from_Data_Stream {
    /*
    class MovingAverage {

        */

    /**
     * Initialize your data structure here.
     *//*
        public MovingAverage(int size) {

        }

        public double next(int val) {

        }
    }
    */

    class MovingAverage {
        double sum;
        int size;
        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);
            if (queue.size() > size)
                sum -= queue.poll();
            return sum / size;
        }
    }

    public static void main(String[] args) {
        Day_08_Premium_Moving_Average_from_Data_Stream obj = new Day_08_Premium_Moving_Average_from_Data_Stream();
        MovingAverage movingAverage = obj.new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
