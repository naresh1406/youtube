package main.cp.leetcode.december;

/**
 * Created by Naresh Gupta on 5/12/2020 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=C4rNB2zXS9Q
 */
public class Day_05_605_Can_Place_Flowers {
    // 1. Data Preprocessing
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int l = flowerbed.length;
            int[] A = new int[l + 2];
            for (int i = 0; i < l; i++)
                A[i + 1] = flowerbed[i];

            int count = 0;
            for (int i = 1; i <= l; i++) {
                if (A[i] == 0 && A[i - 1] == 0 && A[i + 1] == 0) {
                    count++;
                    A[i] = 1;
                }
            }

            return count >= n;
        }
    }

    // 2. Prev and Next Flower empty check
    class Solution2 {
        public boolean canPlaceFlowers(int[] A, int n) {
            int l = A.length;
            int count = 0;
            for (int i = 0; i < l; i++) {
                if (A[i] == 0) {
                    int prev = i == 0 ? 0 : A[i - 1];
                    int next = i == l - 1 ? 0 : A[i + 1];
                    if ((prev | next) == 0) { // if(prev == 0 &&  next == 0) {
                        A[i] = 1;
                        count++;
                    }
                }
            }

            return count >= n;
        }
    }
}
