package com.denisvlem.yandex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PhoneNumbersTest {

    static Stream<Arguments> getFormatArgs() {
        return Stream.of(
            Arguments.of("8(495)430-23-97", "4954302397"),
            Arguments.of("+7-4-9-5-43-023-97", "4954302397"),
            Arguments.of("4302397", "4954302397")
        );
    }

    @ParameterizedTest
    @MethodSource("getFormatArgs")
    void testFormatNumber(String given, String expected) {
        assertThat(PhoneNumbers.formatNumber(given)).isEqualTo(expected);
    }

}