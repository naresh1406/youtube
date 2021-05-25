package main.cp.google;

import java.util.Scanner;

/**
 * Created by Naresh Gupta on 25/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=CknNx7qmkwQ
 */
public class KickStart2021RoundCQ2 {
    // Leetcode problem - 829. Consecutive Numbers Sum
    class Solution {
        public int consecutiveNumbersSum(int n) {
            int count = 0;
            for (int k = 1; k * k < 2 * n; k++) {
                if (((n - (k * (k - 1)) / 2) % k) == 0)
                    count++;
            }

            return count;
        }
    }
}


// Code Submitted in Contest

/**
 * Created by Naresh Gupta on 23/5/2021 AD.
 */
class KickStart2021RoundCQ2_Contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            // read input
            long G = sc.nextLong();
            // solve problem
            System.out.println("Case #" + i + ": " + countK(G));
        }
    }

    private static long countK(long G) {
        long count = 0;
        long n = 1;
        long sum = 0;
        while (true) {
            sum = (n * (n - 1)) / 2;
            if (sum >= G)
                break;
            if ((G - sum) % n == 0) {
//                System.out.println(sum + " " + n + " " + G + " (G - sum) / n = " + (G - sum) / n);
                count++;
            }
            n++;
        }

        return count;
    }
}