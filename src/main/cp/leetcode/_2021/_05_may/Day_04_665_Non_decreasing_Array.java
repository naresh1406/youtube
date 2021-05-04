package main.cp.leetcode._2021._05_may;

/**
 * Created by Naresh Gupta on 4/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=clq-Qs4ze6I
 */
public class Day_04_665_Non_decreasing_Array {
    class Solution {
        public boolean checkPossibility(int[] A) {
            int count = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] > A[i]) {
                    count++;
                    if (i - 2 < 0 || A[i - 2] <= A[i])
                        A[i - 1] = A[i];
                    else
                        A[i] = A[i - 1];
                }
            }

            return count <= 1;
        }
    }

    class Solution2 {
        public boolean checkPossibility(int[] A) {
            int count = 0;
            for (int i = 1, prev = A[0]; i < A.length; i++) {
                if (prev > A[i]) {
                    if (count++ > 0)
                        return false;
                    if (i - 2 >= 0 && A[i - 2] > A[i])
                        continue;
                }
                prev = A[i];
            }
            return true;
        }
    }

    class Solution3 {
        public boolean checkPossibility(int[] A) {
            for (int i = 1; i < A.length; i++) {
                if (A[i - 1] > A[i]) {
                    if (isSorted(A, i - 1) || isSorted(A, i))
                        return true;
                    return false;
                }
            }

            return true;
        }

        private boolean isSorted(int[] A, int index) {
            int n = A.length;
            for (int i = 0; i < A.length - 1; i++) {
                if (i == index)
                    i++;
                int j = i + 1;
                if (j == index)
                    j++;
                if (j < n && A[i] > A[j])
                    return false;
            }

            return true;
        }
    }

}
