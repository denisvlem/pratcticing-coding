package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestAscendingSubsequenceTest {


    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(new int[]{1,2,-1,3,4,5}, 5),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1,2,3,2,3,4}, 4),
                Arguments.of(new int[]{1,2,3,2,3,4,5}, 5),
                Arguments.of(new int[]{-1,2,-3,-2,3,4,5}, 5),
                Arguments.of(new int[]{1,2,3,1,2,3,4,1,2,3}, 4),
                Arguments.of(new int[]{3,2,1}, 1)
        );
    }

    @MethodSource("getArgs")
    @ParameterizedTest
    void testLongestAscendingSubsequence(int[] givenArray, int expectedResult) {
        var solution = new LongestAscendingSubsequence();
        assertThat(solution.solution(givenArray)).isEqualTo(expectedResult);
    }

}