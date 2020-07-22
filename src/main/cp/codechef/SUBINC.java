package main.cp.codechef;

import java.util.Scanner;

public class SUBINC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int prevValue = sc.nextInt();
            int prevSubCount = 1;
            long count = 1;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                prevSubCount = a >= prevValue ? prevSubCount + 1 : 1;
                count += prevSubCount;
                prevValue = a;
            }
            System.out.println(count);
        }
    }
}
