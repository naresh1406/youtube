package main.cp.leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Day 04 Ugly Number II
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
 */
public class Day_04_Ugly_Number_II {
    // 1. Brute Force
    class Solution {
        public int nthUglyNumber(int n) {
            int num = 0;
            while (n > 0) {
                ++num;
                if (isUgly(num))
                    n--;
            }
            return num;
        }

        public boolean isUgly(int num) {
            for (int i = 2; i < 6 && num > 0; i++)
                while (num % i == 0)
                    num /= i;
            return num == 1;
        }
    }

    // 2. Pre-compute All Ugly Numbers
    class Solution2 {
        int nthUglyNumber(int n) {
            List<Integer> ugly = new ArrayList<>();
            long two, three, five, m = Integer.MAX_VALUE; // long - not let overflow.
            for (two = 1; two <= m; two *= 2)
                for (three = two; three <= m; three *= 3)
                    for (five = three; five <= m; five *= 5)
                        ugly.add((int) five);
            Collections.sort(ugly); // sorting list
            return ugly.get(n - 1); // index 0 based
        }
    }

    // 3. DP
    class Solution3 {
        public int nthUglyNumber(int n) {
            if(n <= 0) return 0;

            int twoIndex = 0;
            int threeIndex = 0;
            int fiveIndex = 0;

            List<Integer> ugly = new ArrayList();
            ugly.add(1);

            int nback = n;
            while(n-- > 1) {
                int by2 = ugly.get(twoIndex) * 2;
                int by3 = ugly.get(threeIndex) * 3;
                int by5 = ugly.get(fiveIndex) * 5;

                int min = Math.min(by2, Math.min(by3, by5));
                ugly.add(min);

                if(min == by2) twoIndex++;
                if(min == by3) threeIndex++;
                if(min == by5) fiveIndex++;
            }

            return ugly.get(nback - 1);
        }
    }
}
