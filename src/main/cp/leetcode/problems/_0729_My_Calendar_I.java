package main.cp.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Naresh Gupta on 22/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=dg0tCWF2ta8
 */
public class _0729_My_Calendar_I {

    // TC - O(N^2)
    class MyCalendar_1 {

        List<int[]> meetings;

        public MyCalendar_1() {
            meetings = new ArrayList();
        }

        public boolean book(int start, int end) {
            for (int[] m : meetings)
                if (m[0] <= start && start < m[1] || start <= m[0] && m[0] < end)
                    return false;

            meetings.add(new int[]{start, end});
            return true;
        }
    }

    // TC - O(N Log N)
    class MyCalendar_2 {

        TreeMap<Integer, Integer> map;

        public MyCalendar_2() {
            map = new TreeMap();
        }

        public boolean book(int start, int end) {
            Integer floor = map.floorKey(start);
            Integer ceil = map.ceilingKey(start);

            if (floor != null && map.get(floor) > start || ceil != null && end > ceil)
                return false;

            map.put(start, end);

            return true;
        }
    }

}
