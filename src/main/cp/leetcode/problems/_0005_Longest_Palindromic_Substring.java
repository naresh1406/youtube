package main.cp.leetcode.problems;

/**
 * Detailed Video Explanation https://www.youtube.com/watch?v=8npXbrIH56A
 */
public class _0005_Longest_Palindromic_Substring {
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

    // O(n^3) Brute Force
    class Solution2 {
        public String longestPalindrome(String s) {
            if (isPalindrome(s)) return s;
            for (int len = s.length(); len > 0; len--) {
                for (int i = 0; i + len <= s.length(); i++) {
                    String sub = s.substring(i, i + len);
                    if (isPalindrome(sub))
                        return sub;
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
