package com.denisvlem.strings;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Disabled
class LongestSubstringTest {

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("pwwkew", 3),
                Arguments.of("abcabcd", 4),
                Arguments.of("abcabcdabcd", 4),
                Arguments.of("a", 1),
                Arguments.of("abcdacfgeb", 7),
                Arguments.of("abcbdefg", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("getArgs")
    void test(String inputString, int expectedLength) {
        var longestSubstring = new LongestSubstring();
        assertThat(longestSubstring.lengthOfLongestSubstring(inputString)).isEqualTo(expectedLength);
    }

}