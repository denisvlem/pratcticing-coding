package com.denisvlem.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfSubArrayTest {

    protected SumOfSubArray solution = new SumOfSubArray();

    private static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 3, true),
            Arguments.of(new int[]{1, 1}, 2, true),
            Arguments.of(new int[]{1, 0}, 1, true),
            Arguments.of(new int[]{0, 1}, 1, true),
            Arguments.of(new int[]{1}, 1, true),
            Arguments.of(new int[]{1}, 2, false),
            Arguments.of(new int[]{3, 4, 2, 8, 1, 345}, 363, true),
            Arguments.of(new int[]{3, 4, 2, 8, 1, 345}, 3, true),
            Arguments.of(new int[]{3, 4, 2, 8, 9, 345}, 1, false),
            Arguments.of(new int[]{9, 5, 3, 4, 1}, 1000, false)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testSumOfSubArray(int[] givenArr, int givenTarget, boolean expectedResult) {

        assertThat(solution.sumOfSubArray(givenArr, givenTarget)).isEqualTo(expectedResult);
    }

}