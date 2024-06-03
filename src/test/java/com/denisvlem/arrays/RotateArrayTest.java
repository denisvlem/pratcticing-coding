package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RotateArrayTest {

    static Stream<Arguments> getTestData() {
        return Stream.of(
            Arguments.of(List.of(1,2,3,4,5,6,7), 3, List.of(5,6,7,1,2,3,4)),
            Arguments.of(List.of(-1,-100,3,99), 2, List.of(3,99,-1,-100)),
            Arguments.of(List.of(), 100, List.of())
        );
    }

    private RotateArray solution;

    @BeforeEach
    void init() {
        solution = new RotateArray();
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void testRotateArray(List<Integer> input, int inputK, List<Integer> expectedOutput) {

        var inputArray = input.stream().mapToInt(i -> i).toArray();
        var expectedArray = expectedOutput.stream().mapToInt(i -> i).toArray();

        solution.rotate(inputArray, inputK);

        assertThat(inputArray).isEqualTo(expectedArray);
    }
}