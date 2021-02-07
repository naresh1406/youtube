package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 7/2/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=XorbGp6gysg
 */
public class _1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    class Solution {
        public int minimumLength(String s) {
            // two pointers l - left, r - right
            int l = 0, r = s.length() - 1;
            while (l < r && s.charAt(l) == s.charAt(r)) {
                char ch = s.charAt(l);
                // pefix
                while (l <= r && s.charAt(l) == ch)
                    l++;

                // suffix
                while (r >= l && s.charAt(r) == ch)
                    r--;
            }

            return l > r ? 0 : r - l + 1;
        }
    }
}
