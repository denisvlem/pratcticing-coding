package com.denisvlem.pointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PartitionLabelsTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            "abc", List.of(1, 1, 1)),
        Arguments.of(
            "abac", List.of(3, 1)),
        Arguments.of(
            "", Collections.emptyList()
        )
    );
  }


  @ParameterizedTest
  @MethodSource("getArgs")
  void partitionLabels(String givenString, List<Integer> expectedList) {

    assertThat(new PartitionLabels().partitionLabels(givenString)).isEqualTo(expectedList);
  }
}