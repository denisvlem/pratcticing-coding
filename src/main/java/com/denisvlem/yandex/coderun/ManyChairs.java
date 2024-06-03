package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ManyChairs {

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var nmArray = reader.readLine().split(" ");
            var n = Integer.parseInt(nmArray[0]);
            var m = Integer.parseInt(nmArray[1]);

            var sellers = Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong)
                .toArray(Long[]::new);

            var buyers = Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong)
                .toArray(Long[]::new);

            System.out.println(maxRevenue(n, m, sellers, buyers));
        }
    }

    public static long maxRevenue(int n, int m, Long[] sellers, Long[] buyers) {
        Arrays.sort(sellers);
        Arrays.sort(buyers, Comparator.reverseOrder());
        var i = 0;
        var j = 0;
        long maxRevenue = 0;
        while (i < n && j < m && sellers[i] < buyers[j]) {
            maxRevenue += buyers[j] - sellers[i];
            i++;
            j++;
        }
        return maxRevenue;
    }
}
