package com.denisvlem.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FirstUniqueCharTest {

    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                "", -1
            ),
            Arguments.of(
                "aabb", -1
            ),
            Arguments.of(
                "ab", 0
            ),
            Arguments.of(
                "a", 0
            ),
            Arguments.of(
                "abcdecfgagbcved", 6
            ),
            Arguments.of(
                "aBBbbA", 0
            ),
            Arguments.of(
                "bCdefg", 0
            ),
            Arguments.of(
                "abbbbbbvbbbbbbbbbabbb", 7
            )
        );
    }

    protected FirstUniqueChar solution = new FirstUniqueChar();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testFirstUniqueChar(String givenString, int expectedIndex) {
        var actualIndex = solution.firstUniqChar(givenString);
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }
}