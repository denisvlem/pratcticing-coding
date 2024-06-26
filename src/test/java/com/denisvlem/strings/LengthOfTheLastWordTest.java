package com.denisvlem.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LengthOfTheLastWordTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            "Hello World", 5
        ),
        Arguments.of(
            "   fly me   to   the moon  ", 4
        ),
        Arguments.of(
            "word", 4
        ),
        Arguments.of(
            "    word     ", 4
        ),
        Arguments.of(
            "word     ", 4
        ),
        Arguments.of(
            "    word", 4
        )
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void lengthOfLastWord(String givenString, int expectedLength) {
    assertThat(new LengthOfTheLastWord().lengthOfLastWord(givenString)).isEqualTo(expectedLength);
  }
}