package com.denisvlem.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromicSubstringTest {


    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                "abba", Set.of("abba")
            ),
            Arguments.of(
                "", Set.of("")
            ),
            Arguments.of(
                "babad", Set.of("bab", "aba")
            ),
            Arguments.of(
                "cbbd", Set.of("bb")
            ),
            Arguments.of(
                "a", Set.of("a")
            )
        );
    }


    protected final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testLongestPalindromicSubstring(String givenStr, Set<String> possibleAnswers) {

        var actualResult = solution.longestPalindromicSubstring(givenStr);
        assertThat(possibleAnswers).contains(actualResult);
    }
}