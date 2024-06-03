package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PascalsTriangleTest {


    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(0, Collections.emptyList()),
            Arguments.of(1, List.of(List.of(1))),
            Arguments.of(2, List.of(List.of(1), List.of(1, 1))),
            Arguments.of(3, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1))),
            Arguments.of(4, List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1)))
        );
    }

    protected PascalsTriangle solution = new PascalsTriangle();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testPascalTriangle(int givenSize, List<List<Integer>> expectedTriangle) {

        assertThat(solution.generate(givenSize)).asList().isEqualTo(expectedTriangle);
    }

}