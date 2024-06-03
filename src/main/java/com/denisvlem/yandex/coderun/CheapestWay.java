package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S125", "java:S106"})
public class CheapestWay {

    public static void main(String[] args) throws IOException {
        try (
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            var measures = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            int n = measures.get(0);
            int m = measures.get(1);

            final Integer[][] matrix = new Integer[n][m];
            for (int i = 0; i < n; ++i) {
                matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            }

            writer.write(findCheapestWay(matrix, n, m).toString());
        }
    }

    public static Integer findCheapestWay(Integer[][] matrix, int n, int m) {
        for (int i = 1; i < m; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                var upCell = matrix[i - 1][j];
                var leftCell = matrix[i][j - 1];
                matrix[i][j] += Math.min(upCell, leftCell);
            }
        }
        return matrix[n - 1][m - 1];
    }
}
