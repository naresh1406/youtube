package main.cp.leetcode.august;

public class Day_03_Valid_Palindrome {
    // 1.
    class Solution {
        public boolean isPalindrome(String s) {
            String str = s.toLowerCase();
            int left = 0;
            int right = str.length() - 1;

            while (left <= right) {
                if (!Character.isLetterOrDigit(str.charAt(left))) {
                    left++;
                    continue;
                } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                    right--;
                    continue;
                } else if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }

    // 2. RegEx
    class Solution2 {
        public boolean isPalindrome(String s) {
            String str = s.replaceAll("[^A-Za-z0-9]", "");
            return new StringBuilder(str).reverse().toString().equalsIgnoreCase(str);
        }
    }
}
