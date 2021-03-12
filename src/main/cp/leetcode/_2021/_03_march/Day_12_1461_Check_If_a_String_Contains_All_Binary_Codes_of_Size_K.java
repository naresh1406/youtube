package main.cp.leetcode._2021._03_march;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naresh Gupta on 12/3/2021 AD.
 * Detailed Video Explanation https://www.youtube.com/watch?v=Uj8zeMO6iXE
 */
public class Day_12_1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            Set<String> set = new HashSet();
            for (int i = 0; i < s.length() - k + 1; i++)
                set.add(s.substring(i, i + k));

            return set.size() == (int) Math.pow(2, k);
        }
    }
}
