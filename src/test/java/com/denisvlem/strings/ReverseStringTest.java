package com.denisvlem.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseStringTest {

    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                new char[]{},
                new char[]{}
            ),
            Arguments.of(
                new char[]{'1'},
                new char[]{'1'}
            ),
            Arguments.of(
                new char[]{'1', '2'},
                new char[]{'2', '1'}
            ),
            Arguments.of(
                new char[]{'1', '2', '3'},
                new char[]{'3', '2', '1'}
            ),
            Arguments.of(
                new char[]{'1', '2', '3', '4'},
                new char[]{'4', '3', '2', '1'}
            )
        );
    }

    protected ReverseString solution = new ReverseString();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testReverseString(char[] givenString, char[] expectedString) {

        solution.reverseString(givenString);
        assertThat(givenString).isEqualTo(expectedString);
    }

}