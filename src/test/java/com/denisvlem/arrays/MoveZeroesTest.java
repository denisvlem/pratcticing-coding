package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveZeroesTest {

    static Stream<Arguments> getParams() {
        return Stream.of(
            Arguments.of(new int[]{0,1,0,3,12}, new int[] {1,3,12,0,0}),
            Arguments.of(new int[]{0}, new int[]{0}),
            Arguments.of(new int[]{0,0}, new int[]{0,0}),
            Arguments.of(new int[]{0,1,0}, new int[]{1,0,0}),
            Arguments.of(new int[]{1,1,1}, new int[]{1,1,1})
        );
    }

    protected MoveZeroes solution;

    @BeforeEach
    void init() {
        solution = new MoveZeroes();
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void testMoveZeros(int[] input, int[] output) {
        solution.moveZeroes(input);
        assertThat(input).isEqualTo(output);
    }
}