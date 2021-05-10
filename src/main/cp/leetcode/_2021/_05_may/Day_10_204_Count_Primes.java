package main.cp.leetcode._2021._05_may;

import java.util.Arrays;

/**
 * Created by Naresh Gupta on 10/5/2021 AD.
 * Detailed Video Explanation - https://www.youtube.com/watch?v=ZR9BwOuV6h8
 */
public class Day_10_204_Count_Primes {
    class Solution {
        public int countPrimes(int n) {
            int count = 0;
            for (int i = 2; i < n; i++)
                if (isPrime(i))
                    count++;

            return count;
        }

        private boolean isPrime(int n) {
            if (n < 2)
                return false;
            for (int i = 2; i * i <= n; i++)
                if (n % i == 0)
                    return false;

            return true;
        }
    }

    class Solution_Sieve_of_Eratosthenes {
        public int countPrimes(int n) {
            if (n <= 2)
                return 0;

            boolean[] prime = new boolean[n];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;

            for (int i = 2; i * i <= n; i++) {
                if (prime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        prime[j] = false;
                    }
                }
            }

            int count = 0;
            for (boolean p : prime)
                count += p == true ? 1 : 0;

            return count;
        }
    }
}
