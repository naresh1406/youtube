package main.cp.leetcode._2021._04_april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Naresh Gupta on 30/4/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=KAxZ7lt4G94
 */
public class Day_30_970_Powerful_Integers {
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> result = new HashSet();
            for (int a = 1; a <= bound; a *= x) {
                for (int b = 1; a + b <= bound; b *= y) {
                    result.add(a + b);
                    if (y == 1)
                        break;
                }
                if (x == 1)
                    break;
            }

            return new ArrayList(result);
        }
    }

    class Solution2 {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            List<Integer> xPower = powerList(x, bound);
            List<Integer> yPower = powerList(y, bound);

            Set<Integer> result = new HashSet();
            for (int a : xPower) {
                for (int b : yPower) {
                    if (a + b > bound)
                        break;
                    result.add(a + b);
                }
            }

            return new ArrayList(result);
        }

        private List<Integer> powerList(int x, int bound) {
            List<Integer> list = new ArrayList();
            list.add(1);
            for (int a = x; a <= bound && x != 1; a *= x)
                list.add(a);
            return list;
        }
    }
}
