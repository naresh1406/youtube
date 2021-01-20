package main.cp.leetcode._2021._01_january;

/**
 * Created by Naresh Gupta on 20/1/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=8npXbrIH56A
 */
public class Day_19_5_Longest_Palindromic_Substring {
    // O(n^2)
    class Solution {
        public String longestPalindrome(String s) {
            String lps = "";
            int n = s.length();
            for (int i = 0; i < n; i++) {
                String odd = expandPalindrome(s, i, i);
                String even = expandPalindrome(s, i, i + 1);
                if (lps.length() < odd.length()) {
                    lps = odd;
                }

                if (lps.length() < even.length()) {
                    lps = even;
                }
            }

            return lps;
        }

        private String expandPalindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }

    // Brute Force -TLE

    class Solution2 {
        public String longestPalindrome(String s) {
            if (isPalindrome(s)) return s;
            for (int len = s.length(); len > 0; len--) {
                for (int i = 0; i + len <= s.length(); i++) {
                    if (isPalindrome(s.substring(i, i + len)))
                        return s.substring(i, i + len);
                }
            }
            return "";
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
