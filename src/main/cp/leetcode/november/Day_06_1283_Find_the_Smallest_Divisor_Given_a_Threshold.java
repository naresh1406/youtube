package main.cp.leetcode.november;

/**
 * Created by Naresh Gupta on 6/11/2020 AD.
 */
public class Day_06_1283_Find_the_Smallest_Divisor_Given_a_Threshold {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int d = 1;
            while (getSum(nums, d) > threshold)
                d++;
            return d;
        }

        private int getSum(int[] nums, int d) {
            int sum = 0;
            for (int num : nums)
                sum += (num - 1) / d + 1; // sum += Math.ciel((double)num / d);
            return sum;
        }
    }

    class Solution2 {
        public int smallestDivisor(int[] nums, int threshold) {
            int l = 1, r = 1000001;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long sum = getSum(nums, mid);
                if (sum > threshold)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            return l;
        }

        private long getSum(int[] nums, int d) {
            long sum = 0;
            for (int num : nums)
                sum += (num - 1) / d + 1;
            return sum;
        }
    }
}
