package main.cp.leetcode.august;

public class Day_19_Goat_Latin {
    class Solution {
        public String toGoatLatin(String S) {
            StringBuilder sb = new StringBuilder();
            String suff = "";
            for (String word : S.split(" ")) {
                suff += 'a';
                if ("aeiouAEIOU".indexOf(word.charAt(0)) < 0)
                    word = word.substring(1) + word.charAt(0);
                sb.append(word).append("ma").append(suff).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1); // remove extra space
            return sb.toString();
        }
    }
}
