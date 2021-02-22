package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 22/2/2021 AD.
 * Detailed Video Explanation - https://youtu.be/Eo_d1dKQuqM?t=0¬
 */
public class _1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {
    // Brute Force - TC - O(N^2)

    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            char[] ch = boxes.toCharArray();
            int[] answer = new int[n];

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j && ch[j] == '1')
                        count += Math.abs(i - j);
                }
                answer[i] = count;
            }

            return answer;
        }
    }

    // Optimal - TC - O(N)

    class Solution2 {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            char[] ch = boxes.toCharArray();

            int[] left = new int[n];
            int count = ch[0] - '0';
            for (int i = 1; i < n; i++) {
                left[i] = left[i - 1] + count;
                count += ch[i] - '0';
            }

            int[] right = new int[n];
            count = ch[n - 1] - '0';
            for (int i = n - 2; i >= 0; i--) {
                right[i] = right[i + 1] + count;
                count += ch[i] - '0';
            }

            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = left[i] + right[i];
            }

            return answer;
        }
    }
}
