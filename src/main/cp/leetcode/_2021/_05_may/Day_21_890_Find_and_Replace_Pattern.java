package main.cp.leetcode._2021._05_may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naresh Gupta on 22/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=2jgt3L7spyA
 */
public class Day_21_890_Find_and_Replace_Pattern {
    class Solution {
        // TC - O(n * k), n - number of word in words, k - length of each word
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new ArrayList();
            for (String w : words)
                if (isIsomorphic(w, pattern))
                    result.add(w);

            return result;
        }

        private boolean isIsomorphic(String w, String p) {
            Map<Character, Character> wmap = new HashMap(), pmap = new HashMap();
            for (int i = 0; i < w.length(); i++) {
                char a = w.charAt(i);
                char b = p.charAt(i);
                if (wmap.containsKey(a) && wmap.get(a) != b || pmap.containsKey(b) && pmap.get(b) != a)
                    return false;
                wmap.put(a, b);
                pmap.put(b, a);
            }

            return true;
        }
    }
}
