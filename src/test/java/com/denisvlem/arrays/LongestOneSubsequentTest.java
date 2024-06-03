package com.denisvlem.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestOneSubsequentTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(new int[] {0}, 0),
                Arguments.of(new int[] {}, 0),
                Arguments.of(new int[] {1}, 1),
                Arguments.of(new int[] {1,1,0,1,1,1}, 3),
                Arguments.of(new int[] {1,1,1,0,1,1}, 3),
                Arguments.of(new int[] {1,1,1,1,1,1}, 6),
                Arguments.of(new int[] {0,0,0,0,0,0,0,0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testLongestOneSubsequent(int[] givenArray, int expectedLength) {
        var solution = new LongestOneSubsequent();
        assertThat(solution.solve(givenArray)).isEqualTo(expectedLength);
    }
}