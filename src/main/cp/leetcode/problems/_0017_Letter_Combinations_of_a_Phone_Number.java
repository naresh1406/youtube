package main.cp.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 19/7/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=tfhYQtQkShc
 */
public class _0017_Letter_Combinations_of_a_Phone_Number {
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty())
                return new ArrayList();

            List<String> result = new ArrayList();
            String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            result.add("");
            for (char d : digits.toCharArray()) {
                List<String> list = new ArrayList();
                for (String comb : result) {
                    for (char c : mappings[d - '0'].toCharArray()) {
                        list.add(comb + c);
                    }
                }

                result = list;
            }

            return result;
        }
    }
}
