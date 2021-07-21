package main.cp.leetcode.problems;

import java.util.Random;

/**
 * Created by Naresh Gupta on 20/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=NCpXQshJEk4
 */
public class _0384_Shuffle_an_Array {
    class Solution {

        int[] A;

        public Solution(int[] nums) {
            A = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return A;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] shuffle = A.clone();
            for (int i = shuffle.length - 1; i >= 0; i--) {
                int index = new Random().nextInt(i + 1);
                int temp = shuffle[i];
                shuffle[i] = shuffle[index];
                shuffle[index] = temp;
            }

            return shuffle;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
