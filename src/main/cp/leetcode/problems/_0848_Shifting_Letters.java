package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 8/9/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=v3VqIs2dnUE
 */
public class _0848_Shifting_Letters {
    // TC - O(n), SC - O(n)
    class Solution {
        public String shiftingLetters(String s, int[] shifts) {
            int MOD = 26;
            int n = s.length();
            int[] sum = new int[n];
            sum[n - 1] = shifts[n - 1];
            for (int i = n - 2; i >= 0; i--)
                sum[i] = (sum[i + 1] + shifts[i]) % MOD;

            char[] ch = s.toCharArray();
            for (int i = n - 1; i >= 0; i--) {
                ch[i] = (char) (((ch[i] - 'a') + sum[i]) % MOD + 'a');
            }

            return new String(ch);
        }
    }

    class Solution_2 {
        public String shiftingLetters(String s, int[] shifts) {
            int MOD = 26;
            int n = s.length();
            // int[] sum = new int[n];
            // sum[n - 1] = shifts[n - 1];
            // for(int i = n - 2; i >= 0; i--)
            //     sum[i] = (sum[i + 1] + shifts[i]) % MOD;

            int sum = 0;
            char[] ch = s.toCharArray();
            for (int i = n - 1; i >= 0; i--) {
                sum = (sum + shifts[i]) % MOD;
                ch[i] = (char) (((ch[i] - 'a') + sum) % MOD + 'a');
            }

            return new String(ch);
        }
    }
}
