package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BuyAndSellStockIITest {

    private static Stream<Arguments> getTestData() {
        return Stream.of(
            Arguments.of(List.of(7, 1, 5, 3, 6, 4), 7),
            Arguments.of(List.of(1, 2, 3, 4, 5), 4),
            Arguments.of(List.of(7, 6, 4, 3, 1), 0),
            Arguments.of(List.of(1, 2), 1),
            Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8), 7),
            Arguments.of(List.of(4, 3, 2, 1), 0),
            Arguments.of(List.of(1, 1, 1, 1, 1, 1, 1), 0)
        );
    }

    private BuyAndSellStocksII solution;

    @BeforeEach
    void init() {
        solution = new BuyAndSellStocksII();
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void testMaxProfit(List<Integer> input, int expectedOutput) {
        var inputArray = input.stream().mapToInt(i -> i).toArray();
        assertThat(solution.maxProfit(inputArray)).isEqualTo(expectedOutput);
    }
}
