package com.denisvlem.yandex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PMExpressionTest {

  private static  Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            "1+1", 2
        ),
        Arguments.of("1", 1),
        Arguments.of("2*2", 4),
        Arguments.of("2+2*2", 6),
        Arguments.of("2+2*2+1", 7),
        Arguments.of("2+2*2+1*7", 13)
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void calculate(String expression, int expectedValue) {

    assertThat(PMExpression.calculate(expression)).isEqualTo(expectedValue);
  }
}