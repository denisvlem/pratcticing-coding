package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AddTwoNumbersTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new ListNode(1), new ListNode(2), new ListNode(3)
        ),
        Arguments.of(
            new ListNode(0), new ListNode(0), new ListNode(0)
        ),
        Arguments.of(
            new ListNode(9), new ListNode(9), new ListNode(8, new ListNode(1))
        ), Arguments.of(
            new ListNode(2, new ListNode(4, new ListNode(3))),
            new ListNode(5, new ListNode(6, new ListNode(4))),
            new ListNode(7, new ListNode(0, new ListNode(8)))
        )
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void addTwoNumbers(ListNode left, ListNode right, ListNode expectedSum) {
    var solution = new AddTwoNumbers();
    assertThat(solution.addTwoNumbers(left, right)).hasToString(expectedSum.toString());
  }
}