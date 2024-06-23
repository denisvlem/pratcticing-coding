package com.denisvlem.pointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ThreeSumTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)))
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void threeSum(int[] givenArray, List<List<Integer>> expectedList) {
    List<List<Integer>> result = new ThreeSum().threeSum(givenArray);
    assertThat(result).asList().isEqualTo(expectedList);
  }
}