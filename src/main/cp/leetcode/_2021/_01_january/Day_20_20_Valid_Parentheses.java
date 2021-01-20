package main.cp.leetcode._2021._01_january;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Naresh Gupta on 20/1/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=MT-3nWPtM9k
 */
public class Day_20_20_Valid_Parentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack();
            Map<Character, Character> map = new HashMap();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');

            for (char c : s.toCharArray()) {
                if (map.containsKey(c))
                    st.add(c);
                else if (st.isEmpty() || c != map.get(st.pop()))
                    return false;
            }

            return st.isEmpty();
        }
    }

}
