package main.cp.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class _1338_Reduce_Array_Size_to_The_Half {

    // Using List and Sorting
    class Solution_1 {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr)
                map.put(a, map.getOrDefault(a, 0) + 1);

            List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            int size = 0, total = 0;
            for (int v : list) {
                total += v;
                size++;
                if (total >= arr.length / 2)
                    break;
            }

            return size;
        }
    }

    // Using PQ Max Heap
    class Solution_2 {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            for (int v : map.values()) maxHeap.offer(v);

            int ans = 0, count = 0, half = arr.length / 2;
            while (count < half) {
                count += maxHeap.poll();
                ans++;
            }

            return ans;
        }
    }

    // Bucket Sort
    class Solution_3 {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) map.put(a, map.getOrDefault(a, 0) + 1);

            int[] bucket = new int[100001];
            for (int f : map.values()) bucket[f]++;

            int ans = 0, count = 0, half = arr.length / 2, freq = 100000;
            while (count < half) {
                if (bucket[freq] == 0) {
                    freq--;
                    continue;
                }
                count += freq;
                ans++;
                bucket[freq]--;
            }

            return ans;
        }
    }
}
