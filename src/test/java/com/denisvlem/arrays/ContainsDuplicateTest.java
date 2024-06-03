package com.denisvlem.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsDuplicateTest {

    private static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(List.of(1,2,3,4,5), false),
            Arguments.of(List.of(), false),
            Arguments.of(List.of(1), false),
            Arguments.of(List.of(1,2,3,1), true),
            Arguments.of(List.of(1,1,1,3,3,4,3,2,4,2), true)
        );
    }

    protected ContainsDuplicate solution;

    @BeforeEach
    void init() {
        solution = new ContainsDuplicate();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void testContainsDuplicate(List<Integer> inputList, boolean expectedResult) {
        var inputArray = inputList.stream().mapToInt(i -> i).toArray();
        assertThat(solution.containsDuplicate(inputArray)).isEqualTo(expectedResult);
    }
}
