package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13),
                Arguments.of(8, 21)
        );
    }


    @ParameterizedTest
    @MethodSource("getArgs")
    void testFibonacci(int givenN, int expectedNumber) {
        var solution = new Fibonacci();
        assertThat(solution.calculate(givenN)).isEqualTo(expectedNumber);
    }
}