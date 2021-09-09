package main.cp.leetcode.problems;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 9/9/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Hs72PdsJaRk
 */
public class _0764_Largest_Plus_Sign {
    // TC - O(n^3), SC - O(n^2)
    class Solution_1 {
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(A[i], 1);

            for (int[] m : mines)
                A[m[0]][m[1]] = 0;

            int order = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] == 0)
                        continue;
                    int leftCount = 0;
                    int k = j;
                    while (k >= 0 && A[i][k] == 1) {
                        leftCount++;
                        k--;
                    }

                    int rightCount = 0;
                    k = j;
                    while (k < N && A[i][k] == 1) {
                        rightCount++;
                        k++;
                    }

                    int topCount = 0;
                    k = i;
                    while (k >= 0 && A[k][j] == 1) {
                        topCount++;
                        k--;
                    }

                    int bottomCount = 0;
                    k = i;
                    while (k < N && A[k][j] == 1) {
                        bottomCount++;
                        k++;
                    }

                    order = Math.max(order, Math.min(Math.min(leftCount, rightCount), Math.min(topCount, bottomCount)));
                }
            }

            return order;
        }
    }

    // TC - O(n^2), SC - O(n^2)
    class Solution_2 {
        public int orderOfLargestPlusSign(int N, int[][] mines) {
            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(A[i], 1);

            for (int[] m : mines)
                A[m[0]][m[1]] = 0;

            int[][] L = new int[N][N];
            int[][] R = new int[N][N];

            for (int i = 0; i < N; i++) {
                L[i][0] = A[i][0];
                for (int j = 1; j < N; j++)
                    L[i][j] = A[i][j] == 1 ? L[i][j - 1] + 1 : 0;

                R[i][N - 1] = A[i][N - 1];
                for (int j = N - 2; j >= 0; j--)
                    R[i][j] = A[i][j] == 1 ? R[i][j + 1] + 1 : 0;
            }

            int[][] T = new int[N][N];
            int[][] B = new int[N][N];

            for (int j = 0; j < N; j++) {
                B[0][j] = A[0][j];
                for (int i = 1; i < N; i++)
                    B[i][j] = A[i][j] == 1 ? B[i - 1][j] + 1 : 0;

                T[N - 1][j] = A[N - 1][j];
                for (int i = N - 2; i >= 0; i--)
                    T[i][j] = A[i][j] == 1 ? T[i + 1][j] + 1 : 0;
            }

            int order = 0;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    order = Math.max(order, Math.min(Math.min(L[i][j], R[i][j]), Math.min(T[i][j], B[i][j])));

            return order;
        }
    }

}



