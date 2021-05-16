package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 17/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=jS0cMpcDvDo
 */
public class Day_15_65_Valid_Number {
    class Solution {
        public boolean isNumber(String s) {
            boolean num = false;
            boolean exp = false;
            boolean dot = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = true;
                } else if (c == 'e' || c == 'E') {
                    if (exp || !num)
                        return false;
                    exp = true;
                    num = false;
                } else if (c == '.') {
                    if (dot || exp)
                        return false;
                    dot = true;
                } else if (c == '-' || c == '+') {
                    if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                        return false;
                } else {
                    return false;
                }
            }

            return num;
        }
    }
}
