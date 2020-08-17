package main.cp.leetcode.august;

public class Day_17_Distribute_Candies_to_People {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] result = new int[num_people];
            int index = 0;
            int candie = 1;
            while (candies > 0) {
                result[index++ % num_people] += Math.min(candie, candies);
                candies -= candie;
                candie++;
            }

            return result;
        }
    }

    // 2. Same code just used 1 variable for both person index candie
    class Solution2 {
        public int[] distributeCandies(int candies, int num_people) {
            int[] result = new int[num_people];
            int index = 0;
            while (candies > 0) {
                result[index % num_people] += Math.min(candies, ++index);
                candies -= index;
            }

            return result;
        }
    }
}
