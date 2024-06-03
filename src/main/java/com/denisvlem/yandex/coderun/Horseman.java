package com.denisvlem.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Horseman {

    /**
     * Дана прямоугольная доска 𝑁×𝑀
     * N×M (N строк и 𝑀 столбцов). В левом верхнем углу находится шахматный конь, которого необходимо переместить в
     * правый нижний угол доски. В данной задаче конь может перемещаться на две клетки вниз и одну клетку вправо или на
     * одну клетку вниз и две клетки вправо.
     * <p>
     * Необходимо определить, сколько существует различных маршрутов, ведущих из левого верхнего в правый нижний угол.
     */
    public static void main(String... args) throws IOException {
        try (
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Integer[] measures = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

            int n = measures[0];
            int m = measures[1];

            final var solution = new HorsemanSolution(n, m);
            writer.write(String.valueOf(solution.calculateSteps()));
        }
    }

    public static class HorsemanSolution {
        private final int n;
        private final int m;

        int ways = 0;

        public HorsemanSolution(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public long calculateSteps() {
            if (n <= 0 || m <= 0) {
                return 0;
            }
            int[][] field = new int[n][m];

            field[0][0] = 1;

            for(int row = 0; row < n; ++row) {
                for (int col = 0; col < m; ++col) {
                    var currentCell = field[row][col];
                    if (currentCell > 0) {
                       //downStep
                        if (stepDownIsPossible(row, col)) {
                           field[row+2][col+1] += currentCell;
                        }
                        if (stepRightIsPossible(row, col)) {
                            field[row+1][col+2] += currentCell;
                        }
                    }
                }
            }

            return field[n - 1][m - 1];
        }

        private boolean stepDownIsPossible(int row, int col) {
            return n - 1 >= row + 2 && m - 1 >= col + 1;
        }

        private boolean stepRightIsPossible(int row, int col) {
            return n - 1 >= row + 1 && m - 1 >= col + 2;
        }
    }
}
