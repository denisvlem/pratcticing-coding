package com.denisvlem.yandex;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StairsTest {

  public static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(5,2),
        Arguments.of(1,1),
        Arguments.of(0,0),
        Arguments.of(6,3),
        Arguments.of(29,7),
        Arguments.of(28,7),
        Arguments.of(35,7),
        Arguments.of(Integer.MAX_VALUE, 65535)
    );
  }
  @ParameterizedTest
  @MethodSource("getArgs")
  void maxStairHeight(int n, int expectedResult) {
    assertThat(new Stairs().maxStairHeight(n)).isEqualTo(expectedResult);
  }
}