package com.denisvlem.yandex.coderun.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SAndJ {

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {

            var s = reader.readLine();
            var j = reader.readLine();

            if (s.isEmpty() || j.isEmpty()) {
                System.out.println(0);
                return;
            }

            var solution = j.replaceAll("[" + s + "]", "");
            System.out.println(j.length() - solution.length());
        }
    }
}
