package main.cp.leetcode.problems;

import java.util.Arrays;

public class _1619_Mean_of_Array_After_Removing_Some_Elements {
    class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int n = arr.length;
            double sum = 0;
            for (int i = n / 20; i < n - n / 20; i++)
                sum += arr[i];
            return sum / (n - n / 10);
        }
    }
}
