package main.cp.leetcode.september;

import java.util.*;

public class Day_29_Word_Break {
    // Recursive - TLE
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.contains(s))
                return true;
            for (int i = 1; i <= s.length(); i++) {
                String left = s.substring(0, i);
                if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Top Down DP
    class Solution2 {
        Map<String, Boolean> map = new HashMap();

        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.contains(s))
                return true;
            if (map.containsKey(s))
                return map.get(s);
            for (int i = 1; i <= s.length(); i++) {
                String left = s.substring(0, i);
                if (wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                    map.put(s, true);
                    return true;
                }
            }
            map.put(s, false);
            return false;
        }
    }

    // Bottom UP DP
    class Solution3 {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            Set<String> wordDictSet = new HashSet(wordDict);
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (wordDictSet.contains(s.substring(j, i)) && dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

}
