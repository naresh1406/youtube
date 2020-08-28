package main.cp.leetcode.august;

import java.util.Random;

public class Day_28_Implement_Rand10_Using_Rand7 {
    class SolBase {
        public int rand7() {
            return new Random().nextInt(7) + 1;
        }
    }

    class Solution extends SolBase {
        public int rand10() {
            int result = 40;
            while (result >= 40) {
                result = 7 * (rand7() - 1) + rand7() - 1;
            }

            return result % 10 + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Day_28_Implement_Rand10_Using_Rand7().new Solution();
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
        System.out.println(solution.rand10());
    }
}
