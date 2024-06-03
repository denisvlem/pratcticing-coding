package com.denisvlem.dynamic;

import java.util.Arrays;

public class LongestAscendingSubsequence {

    public int solution(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
