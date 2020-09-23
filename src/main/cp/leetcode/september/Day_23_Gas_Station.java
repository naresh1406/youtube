package main.cp.leetcode.september;

public class Day_23_Gas_Station {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                int total = 0, stopCount = 0, j = i;
                while (stopCount < n) { // loop for n stops
                    total += gas[j % n] - cost[j % n];
                    if (total < 0) // starting from this stop we can't complete trip break
                        break;
                    stopCount++;
                    j++;
                }
                if (stopCount == n && total >= 0)  // if we are able to cover all the stop and fuel +ve return i'th stop
                    return i;
            }

            return -1;
        }
    }

    class Solution2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0, tank = 0, index = 0;
            for (int i = 0; i < cost.length; i++) {
                int consume = gas[i] - cost[i];
                tank += consume;
                if (tank < 0) {
                    index = i + 1;
                    tank = 0;
                }
                total += consume;
            }
            return total < 0 ? -1 : index;
        }
    }
}
