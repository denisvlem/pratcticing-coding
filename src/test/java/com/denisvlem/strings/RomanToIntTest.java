package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RomanToIntTest {


  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of("CCCXIX", 319),
        Arguments.of("IV", 4),
        Arguments.of("DIV", 504),
        Arguments.of("CD", 400)
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void romanToInt(String givenString, int expectedInt) {

    assertThat(new RomanToInt().romanToInt(givenString)).isEqualTo(expectedInt);
  }
}