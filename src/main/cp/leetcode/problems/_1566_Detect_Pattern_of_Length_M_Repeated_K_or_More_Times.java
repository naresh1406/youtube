package main.cp.leetcode.problems;

public class _1566_Detect_Pattern_of_Length_M_Repeated_K_or_More_Times {
    class Solution {
        // TC - O(N)
        // SC - O(1)
        public boolean containsPattern(int[] arr, int m, int k) {
            int count = 0;
            for (int i = 0; i + m < arr.length; i++) {
                count = arr[i] == arr[i + m] ? count + 1 : 0;
                if (count == (k - 1) * m)
                    return true;
            }
            return false;
        }
    }
}
