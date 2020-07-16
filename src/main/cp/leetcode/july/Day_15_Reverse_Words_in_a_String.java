package main.cp.leetcode.july;

/**
 * Day_15_Reverse_Words_in_a_String
 * Problem Link - https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
 */
public class Day_15_Reverse_Words_in_a_String {

    // 1. In-Place
    class Solution {
        public String reverseWords(String s) {
            char[] ch = reverse(s.toCharArray(), 0, s.length() - 1);
            int st = 0, e = 0;
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] != ' ')
                    ch[e++] = ch[i];
                else if(i > 0 && ch[i - 1] != ' ') {
                    reverse(ch, st, e - 1);
                    ch[e++] = ' ';
                    st = e;
                }
            }
            reverse(ch, st, e - 1);
            e = e > 0 && ch[e - 1] == ' ' ? e - 1 : e;
            return new String(ch, 0, e);
        }

        private char[] reverse(char[] ch, int i, int j) {
            while(i < j) {
                char temp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = temp;
            }
            return ch;
        }
    }

    // 2.
    class Solution2 {
        public String reverseWords(String s) {
            String[] words = s.trim().split(" +");
            StringBuilder sb = new StringBuilder();
            for(int i = words.length - 1; i > 0; i--)
                sb.append(words[i] + " ");
            return sb.append(words[0]).toString();
        }
    }
}
