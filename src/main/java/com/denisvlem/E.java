package com.denisvlem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        var checkedSet = new HashSet<Integer>();
        for (var currentElement : arr) {
            if (checkedSet.contains(targetSum - currentElement)) {
                return List.of(targetSum - currentElement, currentElement);
            } else {
                checkedSet.add(currentElement);
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
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