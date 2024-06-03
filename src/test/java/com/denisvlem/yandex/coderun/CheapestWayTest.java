package com.denisvlem.yandex.coderun;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheapestWayTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                new Integer[][]{{4}}, 1, 1, 4
            ),
            Arguments.of(
                new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3, 3, 21
            ), Arguments.of(
                new Integer[][]{{1, 1, 1}, {1, 2, 1}, {1, 1, 1}}, 3, 3, 5
            ), Arguments.of(
                new Integer[][]{{0}}, 1, 1, 0
            ), Arguments.of(
                new Integer[][]{{0, 0, 100}, {100, 0, 100}, {100, 0, 0}}, 3, 3, 0
            ), Arguments.of(
                new Integer[][]{{1,0,1}}, 1, 3, 2
            ), Arguments.of(
                new Integer[][]{{1},{0},{1}}, 3, 1, 2
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void findCheapestWay(Integer[][] givenMatrix, int givenN, int givenM, int expectedResult) {
        assertThat(CheapestWay.findCheapestWay(givenMatrix, givenN, givenM)).isEqualTo(expectedResult);
    }

    @Test
    void cheapestWayMaxSize() {
        int n = 20;
        int m = 20;

        Integer[][] matrix = new Integer[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 100;
            }
        }

        assertThat(CheapestWay.findCheapestWay(matrix, n, m)).isEqualTo(3900);
    }
}