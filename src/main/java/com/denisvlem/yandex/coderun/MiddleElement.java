package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MiddleElement {

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var line = reader.readLine();
            List<Integer> numbersArray = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

            writer.write(numbersArray.get(1).toString());
        }
    }
}
