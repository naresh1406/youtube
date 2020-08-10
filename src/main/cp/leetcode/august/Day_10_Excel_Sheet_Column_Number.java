package main.cp.leetcode.august;

import java.util.stream.IntStream;

public class Day_10_Excel_Sheet_Column_Number {
    // 1. Naive
    class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            for (int i = s.length() - 1, factor = 1; i >= 0; i--, factor *= 26)
                result += (s.charAt(i) - 'A' + 1) * factor;
            return result;
        }
    }

    // 2. Java 8, String.chars() + reduce
    class Solution2 {
        public int titleToNumber(String s) {
            return s.chars().reduce(0, (result, ch) -> result * 26 + (ch - 'A' + 1));
        }
    }

    // 3. Java 8, IntStream + reduce
    class Solution3 {
        public int titleToNumber(String s) {
            return IntStream.range(0, s.length()).reduce(0, (result, i) -> result * 26 + (s.charAt(i) - 'A' + 1));
        }
    }
}
