package main.cp.leetcode.july;

import java.util.*;

/**
 * Day_17_Top_K_Frequent_Elements
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
 */
public class Day_17_Top_K_Frequent_Elements {

    // 1. Min Head - O(NlogK)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // frequency map of numbers
            Map<Integer, Integer> map = new HashMap();
            for(int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);
            //min heap sorting based on frequency of numbers
            PriorityQueue<Integer> pq = new PriorityQueue((num1, num2) -> map.get(num1) - map.get(num2));
            for(int num : map.keySet()) {
                pq.add(num);
                if (pq.size() > k)  // check if size cross k then remove least frequent number from heap among k + 1 most frequency so far.
                    pq.poll();
            }

            int[] top = new int[k];
            for(int i = k - 1; i >= 0; --i)
                top[i] = pq.poll();

            return top;
        }
    }


    // 2. Bucket O(N)
    class Solution2 {
        // TC - O(n), k < n
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            for(int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            List<Integer>[] bucket = new ArrayList[nums.length + 1];
            for(int num : map.keySet()) {
                int freq = map.get(num);
                if(bucket[freq] == null)
                    bucket[freq] = new ArrayList();
                bucket[freq].add(num);
            }

            int[] top = new int[k];
            int index = 0;
            for(int i = bucket.length - 1; i >= 0; i--) {
                if(bucket[i] != null) {
                    for(int num : bucket[i]) {
                        top[index++] = num;
                        if(index == k)
                            return top;
                    }
                }
            }

            return top;
        }
    }
}
