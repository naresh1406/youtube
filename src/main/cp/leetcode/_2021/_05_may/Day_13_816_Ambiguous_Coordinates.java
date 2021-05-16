package main.cp.leetcode._2021._05_may;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 17/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=mBV5NBklHOg
 */
public class Day_13_816_Ambiguous_Coordinates {
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> result = new ArrayList();
            for (int i = 2; i < s.length() - 1; i++)
                for (String left : make(s, 1, i))
                    for (String right : make(s, i, s.length() - 1))
                        result.add("(" + left + ", " + right + ")");

            return result;
        }

        private List<String> make(String s, int i, int j) {
            List<String> list = new ArrayList();
            for (int d = 1; d <= j - i; d++) {
                String left = s.substring(i, i + d);
                String right = s.substring(i + d, j);
                if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0"))
                    list.add(left + (d < j - i ? "." : "") + right);
            }

            return list;
        }
    }
}
