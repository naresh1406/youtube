package main.cp.leetcode._2021._03_march;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naresh Gupta on 27/3/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=qyXtz99u4jY
 */
public class Day_26_916_Word_Subsets {
    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            int[] maxFreqB = new int[26];
            for (String b : B)
                maxFreqB = maxFreqeuncy(maxFreqB, frequency(b));

            List<String> list = new ArrayList();
            for (String a : A)
                if (isUniversal(frequency(a), maxFreqB))
                    list.add(a);

            return list;
        }

        private boolean isUniversal(int[] f, int[] maxFreqB) {
            for (int i = 0; i < f.length; i++)
                if (f[i] < maxFreqB[i])
                    return false;

            return true;
        }

        private int[] maxFreqeuncy(int[] f1, int[] f2) {
            for (int i = 0; i < f1.length; i++)
                f1[i] = Math.max(f1[i], f2[i]);

            return f1;
        }

        private int[] frequency(String s) {
            int[] f = new int[26];
            for (char c : s.toCharArray())
                f[c - 'a']++;

            return f;
        }
    }
}
