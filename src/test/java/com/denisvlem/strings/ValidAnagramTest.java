package com.denisvlem.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidAnagramTest {


    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                "", "", true
            ),
            Arguments.of(
                "a", "a", true
            ),
            Arguments.of(
                "a", "aa", false
            ),
            Arguments.of(
                "aa", "a", false
            ),
            Arguments.of(
                "abc", "cab", true
            ),
            Arguments.of(
                "abca", "abbc", false
            ),
            Arguments.of(
                "aa", "aa", true
            )
        );
    }

    protected ValidAnagram solution = new ValidAnagram();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testValidAnagram(String firstArg, String secondArg, boolean expectedResult) {
        var actualResult = solution.isAnagram(firstArg, secondArg);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}