package main.cp.leetcode.problems;

public class _1556_Thousand_Separator {
    class Solution {
        public String thousandSeparator(int n) {
            if (n < 1000)
                return "" + n;

            String s = "" + n;
            int len = s.length();
            int i = len % 3;

            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i));

            while (i < len) {
                if (i > 0) {
                    sb.append('.');
                }
                sb.append(s.substring(i, Math.min(i + 3, len)));
                i += 3;
            }

            return sb.toString();
        }
    }
}
