package main.cp.leetcode.september;

public class Day_10_Bulls_and_Cows {
    class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0, cows = 0;
            int[] numbers = new int[10];
            for (int i = 0; i < guess.length(); i++) {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                if (s == g) bulls++;
                else {
                    if (numbers[s]++ < 0) cows++;
                    if (numbers[g]-- > 0) cows++;
                }
            }

            return bulls + "A" + cows + "B";
        }
    }
}
