package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOneTest {


    static Stream<Arguments> getParams() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
            Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
            Arguments.of(new int[]{9}, new int[]{1,0}),
            Arguments.of(new int[]{8,9,9,9}, new int[]{9,0,0,0})
        );
    }

    protected PlusOne solution;

    @BeforeEach
    void init() {
        solution = new PlusOne();
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void testPlusOne(int[] input, int[] output) {
        assertThat(solution.plusOne(input)).isEqualTo(output);
    }

}