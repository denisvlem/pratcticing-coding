package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {

    private static Stream<Arguments> getParams() {
        return Stream.of(
            Arguments.of(List.of(), 0, List.of()),
            Arguments.of(List.of(1,1,1), 1, List.of(1)),
            Arguments.of(List.of(1,1,2,2), 2, List.of(1,2)),
            Arguments.of(List.of(1,1,2,2,3,3,4), 4, List.of(1,2,3,4))
        );
    }

    private RemoveDuplicatesFromSortedArray solution;

    @BeforeEach
    void init() {
        solution = new RemoveDuplicatesFromSortedArray();
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void givenSortedArray_whenRemoveDuplicates_shouldReturnNumberOfDuplicates(List<Integer> input,
                                                                              int expectedLength,
                                                                              List<Integer> output) {
        var inputArray = input.stream().mapToInt(i -> i).toArray();
        var expectedArray = output.stream().mapToInt(i -> i).toArray();

        assertThat(solution.removeDuplicates(inputArray)).isEqualTo(expectedLength);

        for(var i = 0; i < expectedLength; ++i) {
            assertThat(inputArray[i]).isEqualTo(expectedArray[i]);
        }
    }

}