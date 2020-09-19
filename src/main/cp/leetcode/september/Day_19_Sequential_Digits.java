package main.cp.leetcode.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day_19_Sequential_Digits {
    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < 10; i++) q.add(i); // add 1 - 9 all digits in queue
            while (q.size() > 0) {
                int curr = q.poll(); // poll curr from queue
                if (curr >= low && curr <= high) result.add(curr); // check if current >= low and <= high add
                int lastDigit = curr % 10;
                int next = curr * 10 + lastDigit + 1; // generate next num
                if (lastDigit < 9 && next <= high) q.add(next); // check if next num <= high add in queue
            }
            return result;
        }
    }

    class Solution2 {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> result = new ArrayList();
            String s = "123456789";
            for (int l = 2; l <= s.length(); l++) {
                for (int j = 0; j <= s.length() - l; j++) {
                    int num = Integer.parseInt(s.substring(j, j + l));
                    if (num > high) return result;
                    if (num >= low) result.add(num);
                }
            }

            return result;
        }
    }
}