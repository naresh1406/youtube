package main.cp.leetcode.july;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Day_30_Word_Break_II
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
 */
public class Day_30_Word_Break_II {
    class Solution {
        Map<String, List<String>> map = new HashMap();

        public List<String> wordBreak(String s, List<String> wordDict) {
            if (map.containsKey(s))
                return map.get(s);
            List<String> result = new LinkedList<>();
            if (wordDict.contains(s))
                result.add(s);
            for (int i = 1; i <= s.length(); i++) {
                String left = s.substring(0, i);
                if (wordDict.contains(left)) {
                    for (String ss : wordBreak(s.substring(i), wordDict)) {
                        result.add(left + " " + ss);
                    }
                }
            }

            map.put(s, result);
            return result;
        }
    }
}
