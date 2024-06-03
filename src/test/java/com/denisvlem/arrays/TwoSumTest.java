package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    protected TwoSum solution;

    @BeforeEach
    void init() {
        solution = new TwoSum();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void testTowSum(int[] inputArray, int inputNum, int[] outputArray) {
        assertThat(solution.twoSum(inputArray, inputNum)).isEqualTo(outputArray);
    }
}