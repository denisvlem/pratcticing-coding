package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Cafe {


    public static void main(String... args) throws IOException {

        try (
            var reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int n = Integer.parseInt(reader.readLine());
            int[] prices = new int[n];

            for (int i = 0; i < n; ++i) {
                prices[i] = Integer.parseInt(reader.readLine());
            }

            Solution solution = calculate(n, prices);
            System.out.println(solution);
        }
    }

    public static Solution calculate(int n, int[] prices) {

        final int INFINITY = Integer.MAX_VALUE - 301;
        int maxCoupones = 0;
        for (int i = 0; i < n; ++i) {
            if (prices[i] > 100) {
                maxCoupones++;
            }
        }

        if(maxCoupones == 0) {
            var solution = new Solution();
            solution.minPrice = Arrays.stream(prices).reduce(Integer::sum).orElseThrow();
            return solution;
        }

        int[][] dp = new int[n + 1][maxCoupones + 1];

        for(int i = 0; i < maxCoupones + 1; ++i) {
            dp[0][i] = INFINITY;
        }
        dp[0][0] = 0;

        int currentCouponsCount = 0;
        for (int day = 1; day < n + 1; ++day) {
            for (int couponRest = 0; couponRest < maxCoupones + 1; ++couponRest) {

                if (prices[day - 1] > 100 && couponRest == 0) {
                    currentCouponsCount++;
                }

                if (couponRest > currentCouponsCount) {
                    dp[day][couponRest] = INFINITY;
                    continue;
                }

                boolean gotACouponToday = couponRest > 0 && (prices[day - 1] > 100);

                int sumTodayIfGotACoupon = gotACouponToday ? dp[day - 1][couponRest - 1] + prices[day - 1] : INFINITY;
                int sumTodayIfSpendMoney = dp[day - 1][couponRest] + prices[day - 1];
                int sumTodayIfSpendCoupon = couponRest < maxCoupones ? dp[day - 1][couponRest + 1] : INFINITY;

                int min = Math.min(sumTodayIfGotACoupon, Math.min(sumTodayIfSpendMoney, sumTodayIfSpendCoupon));

                dp[day][couponRest] = min;
            }
        }

        var result = new Solution();
        result.minPrice = dp[n][0];
        result.couponRest = 0;
        for(int i = 0; i < maxCoupones + 1; ++i) {
            if(dp[n][i] <= result.minPrice) {
                result.minPrice = dp[n][i];
                result.couponRest = i;
            }
        }

        var minPriceIdx = result.couponSpent;

        for (int i = 0; i < n + 1; ++i) {
            System.out.println(Arrays.toString(dp[i]));
        }


        return result;
    }


    public static class Solution {
        public int minPrice;
        public int couponRest;
        public int couponSpent;
        public List<Integer> daysToSpentCoupons = new LinkedList<>();

        @Override
        public String toString() {
            var builder = new StringBuilder(minPrice)
                .append(" \n")
                .append(couponRest)
                .append(" ")
                .append(couponSpent);

            for (var day: daysToSpentCoupons) {
                builder.append("\n").append(day);
            }
            return builder.toString();
        }
    }
}
