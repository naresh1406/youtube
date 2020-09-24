package main.cp.leetcode.september;

public class Day_24_Find_the_Difference {
    class Solution {
        public char findTheDifference(String s, String t) {
            int[] f = new int[26];
            for (char c : t.toCharArray())
                f[c - 'a']++;
            for (char c : s.toCharArray())
                f[c - 'a']--;
            int i = 0;
            for (; i < 26; i++)
                if (f[i] == 1)
                    break;
            return (char) (i + 'a');
        }
    }

    class Solution2 {
        public char findTheDifference(String s, String t) {
            int xor = 0;
            for (char c : s.toCharArray())
                xor ^= c;
            for (char c : t.toCharArray())
                xor ^= c;
            return (char) xor;
        }
    }
}
