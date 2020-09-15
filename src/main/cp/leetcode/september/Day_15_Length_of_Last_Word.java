package main.cp.leetcode.september;

public class Day_15_Length_of_Last_Word {
    class Solution {
        public int lengthOfLastWord(String s) {
            int n = s.length();
            while (n > 0 && s.charAt(n - 1) == ' ') n--;
            int i = n - 1;
            while (i > -1 && s.charAt(i) != ' ') i--;
            return n - 1 - i;
        }
    }

    class Solution2 {
        public int lengthOfLastWord(String s) {
            String[] words = s.split(" ");
            return words.length == 0 ? 0 : words[words.length - 1].length();
        }
    }

    class Solution3 {
        public int lengthOfLastWord(String s) {
            return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
        }
    }
}
