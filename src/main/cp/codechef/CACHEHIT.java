package main.cp.codechef;

import java.util.Scanner;

public class CACHEHIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            int load = 0;
            int prevBlock = Integer.MAX_VALUE;
            while (m-- > 0) {
                int mi = sc.nextInt();
                load += mi / b == prevBlock / b ? 0 : 1;
                prevBlock = mi;
            }
            System.out.println(load);
        }
    }
}
