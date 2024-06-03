package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterSet {

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var inputString = reader.readLine();
            Set<Character> charsSet = reader.readLine().chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
            System.out.println(findMinSubString(charsSet, inputString));
        }
    }

    public static int findMinSubString(Set<Character> charsSet, String inputString) {
        int inputSize = inputString.length();
        int result = inputString.length();
        boolean solved = false;

        var window = new LinkedList<Character>();
        var currentIndex = 0;
        while (currentIndex < inputSize) {

            char currentChar = inputString.charAt(currentIndex);
            if (!window.isEmpty() && currentChar == window.getFirst()) {
                currentIndex++;
                continue;
            }

            boolean nextCharIsFromSet = charsSet.contains(currentChar);
            if (nextCharIsFromSet) {
                window.add(currentChar);
                if (window.containsAll(charsSet)) {
                    result = Math.min(window.size(), result);
                    solved = true;
                    window.removeFirst();
                    if (window.containsAll(charsSet)) {
                        result = Math.min(window.size(), result);
                    }
                }
            } else {
                window.clear();
            }
            currentIndex++;
        }
        return solved ? result : 0;
    }
}
