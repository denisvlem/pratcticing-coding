package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class PalindromeTimeTest {

    static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(24, 60, 16),
                Arguments.of(12, 1234, 4),
                Arguments.of(0, 0, 0),
                Arguments.of(100000, 100000, 10000)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test(int hours, int minutes, int expectedPalindromeCount) {
        var solution = new PalindromeTime();
        assertThat(solution.solution(hours, minutes)).isEqualTo(expectedPalindromeCount);
    }
}