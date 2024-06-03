package com.denisvlem.dynamic;

public class BallAndStairs {

    public int calculateApproaches(int stepNumber) {

        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for (int i = 3; i < stepNumber; ++i) {
            dp[i%3] = dp[0] + dp[1] + dp[2];
        }

        return dp[(stepNumber - 1) % 3];
    }
}
