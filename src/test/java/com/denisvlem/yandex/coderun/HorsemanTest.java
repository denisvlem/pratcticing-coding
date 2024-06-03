package com.denisvlem.yandex.coderun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HorsemanTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(0, 0, 0),
            Arguments.of(1, 1, 1),
            Arguments.of(1, 2, 0),
            Arguments.of(2, 1, 0),
            Arguments.of(3, 3, 0),
            Arguments.of(1, 6, 0),
            Arguments.of(1, 10, 0),
            Arguments.of(10, 1, 0),
            Arguments.of(2, 3, 1),
            Arguments.of(3, 2, 1),
            Arguments.of(2, 2, 0),
            Arguments.of(4, 4, 2),
            Arguments.of(31, 34, 293930),
            Arguments.of(34, 31, 293930)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void testHorseMan(int givenN, int givenM, int expectedResult) {
        var solution = new Horseman.HorsemanSolution(givenN, givenM);
        assertThat(solution.calculateSteps()).isEqualTo(expectedResult);
    }

}