package main.cp.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1502_Can_Make_Arithmetic_Progression_From_Sequence {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int d = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++)
                if (arr[i] - arr[i - 1] != d)
                    return false;
            return true;
        }
    }

    class Solution2 {
        public boolean canMakeArithmeticProgression(int[] arr) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet();

            for (int num : arr) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                set.add(num);
            }
            int n = arr.length;
            int d = max - min;
            if (d % (n - 1) != 0)
                return false;
            d /= (n - 1);
            int i = 0;
            while (i < n) {
                if (!set.contains(min))
                    return false;
                min += d;
                i++;
            }

            return true;
        }
    }
}
