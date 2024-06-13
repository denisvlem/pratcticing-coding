package com.denisvlem.pointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortColorsTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(List.of(2, 0, 1)),
        Arguments.of(List.of(2, 0, 2, 1, 1, 0))
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void sortColors(List<Integer> list) {

    var nums = list.stream().mapToInt(i -> i).toArray();
    new SortColors().sortColors(nums);

    assertThat(nums).isSorted();
  }
}