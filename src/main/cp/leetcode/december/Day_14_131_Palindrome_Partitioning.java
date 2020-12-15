package main.cp.leetcode.december;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 15/12/2020 AD.
 */
public class Day_14_131_Palindrome_Partitioning {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList();
            helper(s, new ArrayList(), result);
            return result;
        }

        private void helper(String s, List<String> currList, List<List<String>> result) {
            if (s.isEmpty())
                result.add(currList);
            for (int i = 1; i <= s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if (isPalindrome(left)) {
                    List<String> copyList = new ArrayList(currList);
                    copyList.add(left);
                    helper(right, copyList, result);
                }
            }
        }

        // Method to check if a stirng is palindrome or not. TC - O(n)
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
