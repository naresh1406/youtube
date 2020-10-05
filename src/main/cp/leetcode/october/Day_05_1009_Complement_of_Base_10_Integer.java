package main.cp.leetcode.october;

public class Day_05_1009_Complement_of_Base_10_Integer {
    class Solution {
        public int bitwiseComplement(int N) {
            if (N == 0) return 1;
            int result = 0, factor = 1;
            while (N > 0) {
                result += factor * (N % 2 == 0 ? 1 : 0);
                N /= 2;
                factor *= 2;
            }
            return result;
        }
    }

    class Solution2 {
        public int bitwiseComplement(int N) {
            return N == 0 ? 1 : ((int) Math.pow(2, ((int) Math.log(N) / Math.log(2) + 1)) - 1) ^ N;
        }
    }

    class Solution3 {
        public int bitwiseComplement(int N) {
            return N == 0 ? 1 : ((1 << Integer.toBinaryString(N).length()) - 1) ^ N;
        }
    }
}
