package main.cp.leetcode.problems;

public class _1526_Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {
    class Solution {
        public int minNumberOperations(int[] target) {
            int operations = target[0];
            for (int i = 1; i < target.length; i++)
                if (target[i] > target[i - 1])
                    operations += target[i] - target[i - 1];
            return operations;
        }
    }
}
