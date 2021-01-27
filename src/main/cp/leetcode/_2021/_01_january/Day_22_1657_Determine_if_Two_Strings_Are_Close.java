package main.cp.leetcode._2021._01_january;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Naresh Gupta on 27/1/2021 AD.
 * Detailed Video Explanation https://youtu.be/zJM3Y__CqCY?t=0
 */
public class Day_22_1657_Determine_if_Two_Strings_Are_Close {

    // TC - O(n)
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length())
                return false;

            int[] f1 = new int[26];
            int[] v1 = new int[26];
            for (char c : word1.toCharArray()) {
                f1[c - 'a']++;
                v1[c - 'a'] = 1;
            }

            int[] f2 = new int[26];
            int[] v2 = new int[26];
            for (char c : word2.toCharArray()) {
                f2[c - 'a']++;
                v2[c - 'a'] = 1;
            }

            Arrays.sort(f1);
            Arrays.sort(f2);

            return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);
        }
    }

    // Java 8
    class Solution2 {
        public boolean closeStrings(String word1, String word2) {
            Map<Character, Long> map1 = word1.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Character, Long> map2 = word2.chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            List<Long> val1 = map1.values().stream().sorted().collect(Collectors.toList());
            List<Long> val2 = map2.values().stream().sorted().collect(Collectors.toList());

            return map1.keySet().equals(map2.keySet()) && val1.equals(val2);
        }
    }
}
