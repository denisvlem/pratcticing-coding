package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseListTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new ListNode(1, new ListNode(2, new ListNode(3))),
            "3 2 1"
        ),
        Arguments.of(
            new ListNode(1), "1"
        ),
        Arguments.of(
            new ListNode(1, new ListNode(2)), "2 1"
        )
    );
  }

  @MethodSource("getArgs")
  @ParameterizedTest
  void reverseList(ListNode givenList, String expectedToString) {
    assertThat(new ReverseList().reverseList(givenList)).hasToString(expectedToString);
  }
}