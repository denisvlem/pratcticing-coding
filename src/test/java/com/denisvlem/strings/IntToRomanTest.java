package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntToRomanTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(1, "I"),
        Arguments.of(4, "IV"),
        Arguments.of(5, "V"),
        Arguments.of(49, "XLIX"),
        Arguments.of(2001, "MMI"),
        Arguments.of(200, "CC"),
        Arguments.of(1994, "MCMXCIV")
    );
  }


  @ParameterizedTest
  @MethodSource("getArgs")
  void intToRoman(int givenN, String expectedRomanN) {
    assertThat(new IntToRoman().intToRoman(givenN)).isEqualTo(expectedRomanN);
  }
}