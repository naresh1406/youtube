package main.cp.leetcode.october;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() < 2)
            return 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            int currDis = Math.max(Math.abs(min - currMax), Math.abs(max - currMin));
            result = Math.max(result, currDis);
            min = Math.min(min, currMin);
            max = Math.max(max, currMax);
        }

        return result;
    }
}

public class Day_01_624_Maximum_Distance_in_Arrays {
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> arrays = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        );

        System.out.println(solution.maxDistance(arrays));
    }
}
