package com.denisvlem.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    protected static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of(
                123,
                321
            ),
            Arguments.of(
                0,
                0
            ),
            Arguments.of(
                -1,
                -1
            ),
            Arguments.of(
                -123,
                -321
            ),
            Arguments.of(
                2_147_483_647,
                0
            ),
            Arguments.of(
                -2147483648,
                0
            )
        );
    }

    protected ReverseInteger solution = new ReverseInteger();

    @ParameterizedTest
    @MethodSource("getArgs")
    void testReverseInteger(int givenInteger, int expectedInteger) {
        int actualInteger = solution.reverse(givenInteger);
        assertThat(actualInteger).isEqualTo(expectedInteger);
    }
}