package main.cp.leetcode.october;

public class Day_19_1007_Minimum_Domino_Rotations_For_Equal_Row {
    class Solution {
        public int minDominoRotations(int[] A, int[] B) {
            int AB = dominoRotations(A, B); // try all A faces same
            int BA = dominoRotations(B, A); // try all B faces same
            return AB == -1 ? BA : BA == -1 ? AB : Math.min(AB, BA);
        }

        private int dominoRotations(int[] A, int[] B) {
            int minRotation = Integer.MAX_VALUE;
            for (int d = 1; d <= 6; d++) {
                int swap = 0;
                int i = 0;
                for (; i < A.length; i++) {
                    if (A[i] == d) continue;
                    else if (B[i] == d) swap++;
                    else break;
                }
                if (i == A.length && minRotation > swap)
                    minRotation = swap;
            }

            return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
        }
    }

    class Solution2 {
        public int minDominoRotations(int[] A, int[] B) {
            int n = A.length;
            int[] faceA = new int[7], faceB = new int[7], same = new int[7];
            for (int i = 0; i < n; i++) {
                faceA[A[i]]++;
                faceB[B[i]]++;
                if (A[i] == B[i]) same[A[i]]++;
            }

            int minRotation = Integer.MAX_VALUE;
            for (int i = 1; i < 7; i++) {
                if (faceA[i] + faceB[i] - same[i] == n) {
                    minRotation = Math.min(minRotation, Math.min(faceA[i], faceB[i]) - same[i]);
                }
            }

            return minRotation == Integer.MAX_VALUE ? -1 : minRotation;
        }
    }
}
