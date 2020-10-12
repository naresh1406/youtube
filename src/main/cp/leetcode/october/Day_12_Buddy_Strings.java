package main.cp.leetcode.october;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day_12_Buddy_Strings {
    class Solution {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) return false;

            if (A.equals(B)) {
                Set<Character> set = new HashSet();
                for (char c : A.toCharArray()) {
                    if (set.contains(c)) return true;
                    set.add(c);
                }
                return false;
            }
            List<Integer> index = new ArrayList();
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) index.add(i);
                if (index.size() > 2) return false;
            }

            return index.size() == 2 && A.charAt(index.get(0)) == B.charAt(index.get(1)) && A.charAt(index.get(1)) == B.charAt(index.get(0));
        }
    }

    class Solution2 {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) return false;

            int freqA[] = new int[26];
            int freqB[] = new int[26];
            for (int i = 0; i < A.length(); i++) {
                freqA[A.charAt(i) - 'a']++;
                freqB[B.charAt(i) - 'a']++;
            }

            for (int i = 0; i < freqA.length; i++)
                if (freqA[i] != freqB[i])
                    return false;

            if (A.equals(B)) {
                for (int i = 0; i < freqA.length; i++) {
                    if (freqA[i] >= 2)
                        return true;
                }
                return false;
            }

            int swapCount = 0;
            for (int i = 0; i < A.length(); i++)
                if (A.charAt(i) != B.charAt(i))
                    swapCount++;

            return swapCount == 2;
        }
    }
}
