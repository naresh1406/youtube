package main.cp.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Day_29_Pancake_Sorting {
    class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> list = new ArrayList();
            for (int n = A.length; n > 0; n--) {
                int index = find(A, n); // first find the index of current target = n
                flip(A, index); // flip the array till that index so that get that element on front of array
                flip(A, n - 1); // now flip the array to move that element on correct position
                list.add(index + 1); // add first flip operation k
                list.add(n); // add second flip operation k
            }

            return list;
        }

        // find method will help to find the index of the target element in the array
        private int find(int[] A, int target) {
            for (int i = 0; i < A.length; i++)
                if (A[i] == target)
                    return i;
            return -1;
        }

        // flip method will help to flip all the element of subarray from [0, j]
        private void flip(int[] A, int j) {
            int i = 0;
            while (i < j) {
                int temp = A[i];
                A[i++] = A[j];
                A[j--] = temp;
            }
        }
    }
}
