package main.cp.leetcode.september;

import java.util.Arrays;

public class Day_25_Largest_Number {
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] s = new String[n];
            for (int i = 0; i < n; i++)
                s[i] = String.valueOf(nums[i]);

            Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));

            StringBuilder sb = new StringBuilder();
            for (String str : s)
                sb.append(str);
            String result = sb.toString();
            return result.startsWith("0") ? "0" : result;
        }
    }

    class Solution2 {
        public String largestNumber(int[] nums) {
            String result = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).reduce((a, b) -> a + b).get();
            return result.startsWith("0") ? "0" : result; // check if result have all 0's then just return "0" else result
        }
    }
}
