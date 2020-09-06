package main.cp.leetcode.problems;

public class _1574_Shortest_Subarray_To_Be_Removed_To_Make_Array_Sorted {
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;
            int s = 0, e = n - 1;

            while (s < n - 1 && arr[s] <= arr[s + 1]) s++;
            if (s == n - 1) return 0; // check if array is already sorted

            while (e >= s && arr[e] >= arr[e - 1]) e--;

            int result = Math.min(n - 1 - s, e);

            int i = 0, j = e;
            while (i <= s && j < n) {
                if (arr[j] >= arr[i]) {
                    result = Math.min(result, j - i - 1);
                    i++;
                } else {
                    j++;
                }
            }

            return result;
        }
    }
}
