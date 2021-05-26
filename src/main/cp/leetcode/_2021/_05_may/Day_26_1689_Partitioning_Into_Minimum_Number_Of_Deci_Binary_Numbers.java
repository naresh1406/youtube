package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 26/5/2021 AD.
 */
public class Day_26_1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {

    class Solution {
        public int minPartitions(String n) {
            int result = 0;
            for (char c : n.toCharArray())
                result = Math.max(result, c - '0');

            return result;
        }
    }

    class Solution_Java8 {
        public int minPartitions(String n) {
//            return n.chars().max().getAsInt() - '0';
            return n.chars().map(c -> (c - '0')).max().getAsInt();
        }
    }

    // Python
    /*
        class Solution:
            def minPartitions(self, n: str) -> int:
                return max(int(c) for c in n)
     */
}
