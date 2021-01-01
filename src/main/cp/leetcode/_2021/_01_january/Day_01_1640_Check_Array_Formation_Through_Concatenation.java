package main.cp.leetcode._2021._01_january;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 1/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=pduV7qHzFaU
 */
public class Day_01_1640_Check_Array_Formation_Through_Concatenation {
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, int[]> map = new HashMap();
            for (int[] piece : pieces)
                map.put(piece[0], piece);

            int[] result = new int[arr.length];
            int ind = 0;
            for (int a : arr)
                for (int p : map.getOrDefault(a, new int[0]))
                    result[ind++] = p;

            return Arrays.equals(arr, result);
        }
    }

    class Solution2 {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < arr.length; i++)
                map.put(arr[i], i);

            for (int[] piece : pieces) {
                if (!map.containsKey(piece[0]))
                    return false;
                int ind = map.get(piece[0]);
                for (int i = 1; i < piece.length; i++) {
                    if (!map.containsKey(piece[i]) || map.get(piece[i]) != ++ind)
                        return false;
                }
            }

            return true;
        }
    }
}
