package main.cp.leetcode.september;

public class Day_26_Teemo_Attacking {
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if (timeSeries.length == 0) return 0;
            int totalTime = 0;
            for (int i = 0; i < timeSeries.length - 1; i++)
                totalTime += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
            return totalTime + duration;
        }
    }
/*
    // Python
    class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
            if len(timeSeries) == 0: return 0
    totalTime = 0
            for i in range(0, len(timeSeries) - 1):
    totalTime += min(duration, timeSeries[i + 1] - timeSeries[i])
        return totalTime + duration
 */

/*
    // C++
    class Solution {
        public:
        int findPoisonedDuration(vector<int>& timeSeries, int duration) {
            if(timeSeries.size() == 0) return 0;
            int totalTime = 0;
            for(int i = 0; i < timeSeries.size() - 1; i++)
                totalTime += min(duration, timeSeries[i + 1] - timeSeries[i]);
            return totalTime + duration;
        }
    };
*/

}
