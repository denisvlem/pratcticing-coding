package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.beans.SimpleBeanInfo;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberTest {

    private static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(List.of(1,1,2,2,3,3,4), 4),
            Arguments.of(List.of(1), 1),
            Arguments.of(List.of(1,5,1,5,3,2,3), 2),
            Arguments.of(List.of(1,-5,1,-5,3,2,3), 2),
            Arguments.of(List.of(1,-1, 1), -1)
        );
    }

    protected SingleNumber solution;

    @BeforeEach
    void init() {
        solution = new SingleNumber();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void testSingleNumber(List<Integer> input, int expectedOutput) {
        var inputArray = input.stream().mapToInt(i -> i).toArray();
        assertThat(solution.singleNumber(inputArray)).isEqualTo(expectedOutput);
    }
}