package com.denisvlem;

import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class C {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        double currentSum = 0;
        for (int i = 0; i < windowSize; ++i) {
            currentSum += arr.get(i);
        }
        List<Double> result = new LinkedList<>();
        result.add(currentSum / windowSize);
        for (int i = 1; i <= n - windowSize; ++i) {
            currentSum -= arr.get(i - 1);
            currentSum += arr.get(i + windowSize - 1);
            double currentAvg = currentSum / windowSize;
            result.add(currentAvg);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
