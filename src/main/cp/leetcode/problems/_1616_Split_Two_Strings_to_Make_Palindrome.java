package main.cp.leetcode.problems;

public class _1616_Split_Two_Strings_to_Make_Palindrome {
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return check(a, b) || check(b, a);
        }

        private boolean check(String a, String b) {
            int l = 0, r = b.length() - 1;
            while (l < r && a.charAt(l) == b.charAt(r)) {
                l++;
                r--;
            }
            if (l >= r) return true;
            return isPalindrome(a.substring(l, r + 1)) || isPalindrome(b.substring(l, r + 1));
        }

        private boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            return l >= r;
        }
    }

    // Brute Force O(n^2) TLE
    class Solution2 {
        public boolean checkPalindromeFormation(String a, String b) {
            for (int i = 0; i < a.length(); i++)
                if (isPalindrome(a.substring(0, i) + b.substring(i)) || isPalindrome(b.substring(0, i) + a.substring(i)))
                    return true;
            return false;
        }

        private boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }

            return l >= r;
        }
    }
}
