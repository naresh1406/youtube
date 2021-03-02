package main.cp.leetcode._2021._03_march;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 2/3/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=avMbM126u7k
 */
public class Day_01_575_Distribute_Candies {
    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet();
            for (int c : candyType)
                set.add(c);
            return Math.min(candyType.length / 2, set.size());
            // return Math.min(candyType.length / 2, Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size());
        }
    }
}
