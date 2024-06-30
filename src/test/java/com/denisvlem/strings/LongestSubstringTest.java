package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class LongestSubstringTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
            Arguments.of("a", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void test(String inputString, int expectedLength) {
        var longestSubstring = new LongestSubstring();
        assertThat(longestSubstring.lengthOfLongestSubstring(inputString)).isEqualTo(expectedLength);
    }

}