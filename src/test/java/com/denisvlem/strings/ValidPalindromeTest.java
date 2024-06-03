package com.denisvlem.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {

    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                "aa", true
            ),
            Arguments.of(
                "", true
            ),
            Arguments.of(
                "   ::: : : ::#$%^&*( : ", true
            ),
            Arguments.of(
                "   ::a: : : ::#$%a^&*( : ", true
            ),
            Arguments.of(
                "aab", false
            ),
            Arguments.of(
                "aabb1", false
            ),
            Arguments.of(
                "a.", true
            ),
            Arguments.of(
                "a", true
            )
        );
    }

    protected ValidPalindrome solution = new ValidPalindrome();


    @ParameterizedTest
    @MethodSource("getArgs")
    void testValidPalindrome(String givenString, boolean expectedResponse) {

        var actualResponse = solution.isPalindrome(givenString);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}