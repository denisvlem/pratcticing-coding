package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueElements {

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var size = Integer.parseInt(reader.readLine());
            var elements = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            int repeated = getRepeated(size, elements);
            System.out.println(size - repeated);
        }
    }

    private static int getRepeated(int size, List<Integer> elements) {
        elements.sort(Comparator.naturalOrder());
        int repeated = 0;
        int i = 0;
        while(i < size - 1) {
            if(elements.get(i).equals(elements.get(i + 1))) {
                repeated += 2;
                var nextRepeatedElementIndex = i + 2;
                while(nextRepeatedElementIndex < size && elements.get(nextRepeatedElementIndex)
                    .equals(elements.get(i))) {
                    repeated++;
                    nextRepeatedElementIndex++;
                }
                i = nextRepeatedElementIndex;
            } else {
                ++i;
            }
        }
        return repeated;
    }
}
