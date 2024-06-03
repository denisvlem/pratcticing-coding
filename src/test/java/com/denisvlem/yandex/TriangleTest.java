package com.denisvlem.yandex;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(3, 4, 5, true),
        Arguments.of(3, 5, 4, true),
        Arguments.of(4, 3, 5, true),
        Arguments.of(4, 5, 3, true),
        Arguments.of(5, 4, 3, true),
        Arguments.of(5, 3, 4, true),
        Arguments.of(1, 1, 1, true),
        Arguments.of(1, 75, 100, false),
        Arguments.of(3, 4, 10, false),
        Arguments.of(4, 3, 10, false),
        Arguments.of(10, 4, 3, false),
        Arguments.of(2, 1, 3, false),
        Arguments.of(1, 2, 3, false),
        Arguments.of(3, 1, 2, false)
        );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void test(int a, int b, int c, boolean expResult) {
    assertThat(Triangle.canBeATriangle(a, b, c)).isEqualTo(expResult);
  }
}