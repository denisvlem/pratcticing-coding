package com.denisvlem.dynamic;

import java.util.Arrays;

public class Fibonacci {

    private static final int MAX_N = 100;
    int[] dp = new int[MAX_N];

    public Fibonacci() {
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
    }
    public int calculate(int n) {

        if (n < 2) {
            return dp[n];
        }

        for(int i = 2; i <=  n; ++i) {
            if (dp[i] == -1) {
                System.out.printf("Calculating fibonacci for i=%s%n", i);
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
