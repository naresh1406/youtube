package main.cp.leetcode.december;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 22/12/2020 AD.
 * Detatiled Video Explanation https://youtu.be/XHlA0KdvQBc?t=0
 */
public class Day_17_454_4Sum_II {
    // TC - O(n^2)

    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap();
            for (int c : C)
                for (int d : D)
                    map.put(c + d, map.getOrDefault(c + d, 0) + 1);
            int count = 0;
            for (int a : A)
                for (int b : B)
                    count += map.getOrDefault(-(a + b), 0);
            return count;
        }
    }

    // TC - O(n^3)

    class Solution2 {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap();
            for (int d : D)
                map.put(d, map.getOrDefault(d, 0) + 1);
            int count = 0;
            for (int a : A)
                for (int b : B)
                    for (int c : C)
                        count += map.getOrDefault(-(a + b + c), 0);
            return count;
        }
    }

    // TC - O(n^4)

    class Solution3 {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int count = 0;
            for (int a : A)
                for (int b : B)
                    for (int c : C)
                        for (int d : D)
                            if (a + b + c + d == 0)
                                count++;
            return count;
        }
    }
}
