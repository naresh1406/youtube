package main.cp.leetcode.september;

public class Day_09_Compare_Version_Numbers {
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] s1 = version1.split("\\."); // split the version on . character
            String[] s2 = version2.split("\\.");

            int maxLength = Math.max(s1.length, s2.length);
            for (int i = 0; i < maxLength; i++) {  // loop for max length
                int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0; // check if s1 still have level then parsetInt or else 0
                int v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0; // check if s2 still have level then parsetInt or else 0
                if (v1 > v2) // just compare on each level whenever any condition true return in case of v1 == v2 continue
                    return 1;
                else if (v1 < v2)
                    return -1;
            }

            return 0;
        }
    }
}
