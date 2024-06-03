package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestWay {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            Integer[] measures = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

            int n = measures[0];
            int m = measures[1];

            Integer[][] matrix = new Integer[n][m];

            for (int i = 0; i < n; ++i) {
                matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            }

            writer.write(longestWay(matrix, n, m).toString() + "\n");
            List<Character> route = makeRoute(matrix, n, m);
            for (var step : route) {
                writer.write(step + " ");
            }

        }
    }

    public static Integer longestWay(Integer[][] matrix, int n, int m) {

        for (int row = 1; row < n; ++row) {
            matrix[row][0] += matrix[row - 1][0];
        }

        for (int col = 1; col < m; ++col) {
            matrix[0][col] += matrix[0][col - 1];
        }

        for (int row = 1; row < n; ++row) {
            for (int col = 1; col < m; ++col) {
                var upCell = matrix[row - 1][col];
                var leftCell = matrix[row][col - 1];
                if (upCell > leftCell) {
                    matrix[row][col] += upCell;
                } else {
                    matrix[row][col] += leftCell;
                }
            }
        }

        return matrix[n - 1][m - 1];
    }

    public static List<Character> makeRoute(Integer[][] matrix, int n, int m) {
        var route = new LinkedList<Character>();
        int row = n - 1;
        int col = m - 1;
        while (row > 0 || col > 0) {
            if (col == 0) {
                route.addFirst('D');
                row -= 1;
            } else if (row == 0) {
                route.addFirst('R');
                col -= 1;
            } else {
                var leftCellPrice = matrix[row][col - 1];
                var rightCellPrice = matrix[row - 1][col];
                if (leftCellPrice > rightCellPrice) {
                    route.addFirst('R');
                    col -= 1;
                } else {
                    route.addFirst('D');
                    row -= 1;
                }
            }
        }
        return route;
    }
}
