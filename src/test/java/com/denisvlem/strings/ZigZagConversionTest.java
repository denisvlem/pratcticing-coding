package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ZigZagConversionTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            "abc", 3, "abc"
        ),
        Arguments.of(
            "abcdefg", 3, "aebdfcg"
        ),
        Arguments.of(
            "abcdefg", 1, "abcdefg"
        )
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void convert(String givenString, int givenNumRows, String expectedString) {
    String result = new ZigZagConversion().convert(givenString, givenNumRows);

    assertThat(result).isEqualTo(expectedString);
  }
}