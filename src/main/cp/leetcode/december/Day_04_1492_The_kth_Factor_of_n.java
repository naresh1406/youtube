package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 4/12/2020 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=UzVQ9zRVsWg
 */
public class Day_04_1492_The_kth_Factor_of_n {
    // O(n) Solution
    class Solution {
        public int kthFactor(int n, int k) {
            for (int i = 1; i <= n; i++) {
                if (n % i == 0 && --k == 0)
                    return i;
            }
            return -1;
        }
    }

    // O(sqrt(n)) Solution
    class Solution2 {
        public int kthFactor(int n, int k) {
            for (int i = 1; i * i < n; i++) {
                if (n % i == 0 && --k == 0)
                    return i;
            }
            for (int i = (int) Math.sqrt(n); i >= 1; i--) {
                if (n % i == 0 && --k == 0)
                    return n / i;
            }
            return -1;
        }
    }
}
