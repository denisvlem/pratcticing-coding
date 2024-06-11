package com.denisvlem.pointers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntersectionOfTwoArraysIITest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
        Arguments.of(new int[]{4,9,5}, new int[]{9,4,9,8,4}, new int[] {4,9})
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void intersect(int[] nums1, int[] nums2, int[] expectedNum) {

    assertThat(new IntersectionOfTwoArraysII().intersect(nums1, nums2)).isEqualTo(expectedNum);
  }
}