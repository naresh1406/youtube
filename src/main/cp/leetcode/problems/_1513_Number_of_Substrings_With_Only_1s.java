package main.cp.leetcode.problems;

public class _1513_Number_of_Substrings_With_Only_1s {
    class Solution {
        public int numSub(String s) {
            int result = 0, count = 0, mod = 1_000_000_007;
            for(int i = 0; i < s.length(); i++) {
                count = s.charAt(i) == '1' ? count + 1 : 0;
                result = (result + count) % mod;
            }
            return result;
        }
    }
}
