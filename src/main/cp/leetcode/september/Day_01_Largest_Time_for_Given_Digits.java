package main.cp.leetcode.september;

import java.util.ArrayList;
import java.util.List;

public class Day_01_Largest_Time_for_Given_Digits {
    // 1. Generate All Permutations
    class Solution {
        public String largestTimeFromDigits(int[] A) {
            List<String> permutations = permutations(A);
            String res = "";
            for (String p : permutations) {
                String HH = p.substring(0, 2);
                String MM = p.substring(2);
                if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                    res = HH + ":" + MM;
            }

            return res;
        }

        private List<String> permutations(int[] A) {
            String s = "";
            for (int a : A)
                s += a;
            List<String> list = new ArrayList();
            permutations(s, "", list);
            return list;
        }

        private void permutations(String s, String sofar, List<String> list) {
            if (s.isEmpty()) list.add(sofar);

            for (int i = 0; i < s.length(); i++) {
                permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list);
            }
        }
    }

    class Solution2 {
        public String largestTimeFromDigits(int[] A) {
            String res = "";
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (i == j || j == k || i == k)
                            continue;
                        String HH = A[i] + "" + A[j];
                        String MM = A[k] + "" + A[6 - i - j - k];
                        String TIME = HH + ":" + MM;
                        if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(TIME) < 0)
                            res = TIME;
                    }
                }
            }
            return res;
        }
    }
}
