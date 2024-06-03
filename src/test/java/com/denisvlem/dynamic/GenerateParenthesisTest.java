package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesisTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 5),
                Arguments.of(4, 14),
                Arguments.of(5, 42)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testGenerate(int n, int expectedSize) {
        var solution = new GenerateParenthesis();
        assertThat(solution.generateParenthesis(n)).hasSize(expectedSize);
    }
}