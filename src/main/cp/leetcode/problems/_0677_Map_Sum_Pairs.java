package main.cp.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 30/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=AaMIYNdOz8w
 */
public class _0677_Map_Sum_Pairs {

    class MapSum {
        /**
         * Initialize your data structure here.
         */
        private Map<String, Integer> map;

        public MapSum() {
            map = new HashMap<>();
        }

        // TC - O(1)
        public void insert(String key, int val) {
            map.put(key, val);
        }

        // TC - O(NL)
        public int sum(String prefix) {
            int ans = 0;
            for (String key : map.keySet())
                if (key.startsWith(prefix))
                    ans += map.get(key);

            return ans;
        }
    }

    class MapSum_2 {

        /**
         * Initialize your data structure here.
         */
        private Map<String, Integer> map;
        private Map<String, Integer> sumMap;

        public MapSum_2() {
            map = new HashMap();
            sumMap = new HashMap();
        }

        // TC - O(L ^ L)
        public void insert(String key, int val) {
            int diff = val - map.getOrDefault(key, 0);
            map.put(key, val);
            for (int i = 1; i <= key.length(); i++) {
                String prefix = key.substring(0, i);
                sumMap.put(prefix, sumMap.getOrDefault(prefix, 0) + diff);
            }
        }

        // TC - O(1)
        public int sum(String prefix) {
            return sumMap.getOrDefault(prefix, 0);
        }
    }


    class MapSum_3 {

        /**
         * Initialize your data structure here.
         */
        class TrieNode {
            Map<Character, TrieNode> children = new HashMap();
            int sum = 0;
        }

        private TrieNode root;
        private Map<String, Integer> map;

        public MapSum_3() {
            root = new TrieNode();
            map = new HashMap();
        }

        // TC - O(L)
        public void insert(String key, int val) {
            int diff = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode current = root;
            current.sum += diff;
            for (char c : key.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
                current.sum += diff;
            }
        }

        // TC - O(L)
        public int sum(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                current = current.children.get(c);
                if (current == null)
                    return 0;
            }

            return current.sum;
        }
    }
}
