package main.cp.leetcode._2021._03_march;

/**
 * Created by Naresh Gupta on 29/3/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=nw7ofFCGl6w
 */
public class Day_27_647_Palindromic_Substrings {
    // TC - O(n^3), SC - O(1)
    class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                for (int j = i + 1; j <= s.length(); j++)
                    if (isPalindrome(s.substring(i, j)))
                        count++;

            return count;
        }

        private boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l <= r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }

            return l >= r;
        }
    }

    // TC - O(n^2), SC - O(1)
    class Solution2 {
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++)
                for (int j = i + 1; j <= s.length(); j++)
                    if (isPalindrome(s.substring(i, j)))
                        count++;

            return count;
        }

        private boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l <= r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }

            return l >= r;
        }
    }
}
