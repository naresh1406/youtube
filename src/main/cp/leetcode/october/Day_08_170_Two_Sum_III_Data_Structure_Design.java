package main.cp.leetcode.october;

import java.util.HashMap;
import java.util.Map;

public class Day_08_170_Two_Sum_III_Data_Structure_Design {
    public class TwoSum {

        private Map<Integer, Integer> map = new HashMap();

        /**
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            // write your code here
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            // write your code here
            for (int key : map.keySet()) {
                int target = value - key;
                if (map.containsKey(target)) {
                    if (key == target && map.get(key) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
