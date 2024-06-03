package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IntersectionOfTwoArraysIITest {

    static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(new int[]{1,2,2,1}, new int[]{2,2}, new int[]{2,2}),
            Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[]{4,9}),
            Arguments.of(new int[]{2,2}, new int[]{2}, new int[]{2}),
            Arguments.of(new int[]{1,2}, new int[]{1,1}, new int[]{1})
        );
    }
    private IntersectionOfTwoArraysII solution;

    @BeforeEach
    void init() {
        solution = new IntersectionOfTwoArraysII();
    }


    @ParameterizedTest
    @MethodSource("getArguments")
    void testIntersection(int[] input1, int[] input2, int[] output) {
        assertThat(solution.intersect(input1, input2)).isEqualTo(output);
    }
}