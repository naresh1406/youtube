package main.cp.leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class _1507_Reformat_Date {
    class Solution {
        public String reformatDate(String date) {
            String[] d = date.split(" ");
            int dd = Integer.parseInt(d[0].substring(0, d[0].length() - 2));
            String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            List<String> monthList = Arrays.asList(month);
            int mm = monthList.indexOf(d[1]) + 1;
            return d[2] + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd);
        }
    }
}
