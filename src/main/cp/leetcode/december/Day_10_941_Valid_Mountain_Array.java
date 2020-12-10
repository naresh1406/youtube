package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 11/12/2020 AD.
 */
public class Day_10_941_Valid_Mountain_Array {
    class Solution {
        public boolean validMountainArray(int[] arr) {
            int n = arr.length, i = 0, j = n - 1;
            if (n < 3) return false;
            while (i + 1 < n - 1 && arr[i] < arr[i + 1]) i++;
            while (j - 1 > 0 && arr[j] < arr[j - 1]) j--;
            return i == j;
        }
    }
}
