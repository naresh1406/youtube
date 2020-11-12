package main.cp.leetcode.november;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 12/11/2020 AD.
 */
public class Day_11_593_Valid_Square {
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            Set<Integer> set = new HashSet();
            set.add(ds(p1, p2));
            set.add(ds(p1, p3));
            set.add(ds(p1, p4));
            set.add(ds(p2, p3));
            set.add(ds(p2, p4));
            set.add(ds(p3, p4));
            return !set.contains(0) && set.size() == 2;
        }

        // distance square method
        private int ds(int[] a, int[] b) {
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        }
    }

    class Solution2 {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            Set<Integer> set = new HashSet(Arrays.asList(ds(p1, p2), ds(p1, p3), ds(p1, p4), ds(p2, p3), ds(p2, p4), ds(p3, p4)));
            return !set.contains(0) && set.size() == 2;
        }

        // distance square method
        private int ds(int[] a, int[] b) {
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        }
    }
}
