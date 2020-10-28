package main.cp.leetcode.october;

import java.util.ArrayList;
import java.util.List;

public class Day_28_228_Summary_Ranges {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            int n = nums.length;
            List<String> list = new ArrayList();
            for (int i = 0; i < n; i++) {
                int start = nums[i];
                while (i + 1 < n && nums[i + 1] - nums[i] == 1) // check if we have more element nums[i + 1] = nums[i] + 1
                    i++;
                if (start != nums[i])  // more than one element for range add range "->" separated
                    list.add("" + start + "->" + nums[i]); // single element in range just add it
                else
                    list.add("" + start);
            }

            return list;
        }
    }
}
