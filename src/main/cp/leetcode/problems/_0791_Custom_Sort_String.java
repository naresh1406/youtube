package main.cp.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naresh Gupta on 13/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=yJX482FzB-E
 */
public class _0791_Custom_Sort_String {
    class Solution1 {
        public String customSortString(String order, String str) {
            Map<Character, Integer> map = new HashMap();
            for (int i = 0; i < order.length(); i++)
                map.put(order.charAt(i), i);

            Character[] ch = new Character[str.length()];
            for (int i = 0; i < str.length(); i++)
                ch[i] = str.charAt(i);

            Arrays.sort(ch, (a, b) -> Integer.compare(map.getOrDefault(a, 0), map.getOrDefault(b, 0)));

            StringBuilder sb = new StringBuilder();
            for (Character c : ch)
                sb.append(c);

            return sb.toString();
        }
    }

    class Solution2 {
        public String customSortString(String order, String str) {
            int[] freq = new int[26];
            for (char c : str.toCharArray())
                freq[c - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (char c : order.toCharArray())
                while (freq[c - 'a']-- > 0)
                    sb.append(c);

            for (char c = 'a'; c <= 'z'; c++)
                while (freq[c - 'a']-- > 0)
                    sb.append(c);

            return sb.toString();
        }
    }
}
