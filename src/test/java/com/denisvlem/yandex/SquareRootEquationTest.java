package com.denisvlem.yandex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SquareRootEquationTest {

    static Stream<Arguments> resultArgs() {
        return Stream.of(
            Arguments.of(1.0f, 0.0f, 0.0f, 0),
            Arguments.of(1.0f, 2.0f, 3.0f, 7)
        );
    }

    static Stream<Arguments> noSolutionArgs() {
        return Stream.of(
            Arguments.of(1.0f, 2.0f, -3.0f, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("resultArgs")
    void testCalculateSquareRootResult(Float a, Float b, Float c, int expectedResult) {
        assertThat(SquareRootEquation.calculateSquareRootEquation(a, b, c)).isEqualTo(expectedResult);
    }


    @ParameterizedTest
    @MethodSource("noSolutionArgs")
    void testCalculateSquareRootNoSolution(Float a, Float b, Float c) {
        assertThatThrownBy(() -> SquareRootEquation.calculateSquareRootEquation(a, b, c))
            .isInstanceOf(IllegalArgumentException.class);
    }

}