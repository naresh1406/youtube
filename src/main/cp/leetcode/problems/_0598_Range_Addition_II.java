package main.cp.leetcode.problems;

/**
 * Created by Naresh Gupta on 30/8/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=Osl6MC3D-fI
 */
public class _0598_Range_Addition_II {
    class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int[] common = new int[]{m, n};
            for (int[] op : ops) {
                common[0] = Math.min(common[0], op[0]);
                common[1] = Math.min(common[1], op[1]);
            }

            return common[0] * common[1];
        }
    }
}
