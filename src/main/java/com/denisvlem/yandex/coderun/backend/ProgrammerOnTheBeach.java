package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProgrammerOnTheBeach {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            var t = Integer.parseInt(reader.readLine());
            int[] results = new int[t];
            for (int i = 0; i < t; ++i) {
                var n = Integer.parseInt(reader.readLine());
                var measures = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).sorted().toArray(Integer[]::new);

                var minDiff = Integer.MAX_VALUE;
                for (int j = 0; j < n - 1; ++j) {
                    var currentDiff = measures[j] ^ measures[j + 1];
                    if (minDiff > currentDiff) {
                        minDiff = currentDiff;
                    }
                }
                if (minDiff == Integer.MAX_VALUE) {
                    minDiff = 0;
                }

                results[i] = minDiff;
            }

            for (int i = 0; i < t; ++i) {
                System.out.println(results[i]);
            }
        }
    }
}
