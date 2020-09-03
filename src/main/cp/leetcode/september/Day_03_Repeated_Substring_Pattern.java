package main.cp.leetcode.september;

public class Day_03_Repeated_Substring_Pattern {
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int l = n / 2; l > 0; l--) {
                if (n % l == 0) {
                    int i = 0;
                    while (i + l < n && s.charAt(i) == s.charAt(i + l))
                        i++;
                    if (i + l == n)
                        return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).substring(1, 2 * s.length() - 1).contains(s);
        }
    }

//    3. RegEx
//    [a-z] => a-z characters
//    [a-z]+ => [a-z] characters more than once
//    \1 => The backreference \1 (backslash one) references the first capturing group. \1 matches the exact same text that was matched by the first capturing group.
//    \1+ => more such groups
    class Solution3 {
        public boolean repeatedSubstringPattern(String s) {
            return s.matches("^([a-z]+)\\1+$");
        }
    }
}
