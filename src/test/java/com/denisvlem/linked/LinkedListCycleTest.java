package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LinkedListCycleTest {

  static Stream<Arguments> getArgs() {

    var cycleStart = new ListNode(1);
    var cycleEnd = new ListNode(3, cycleStart);
    cycleStart.next = new ListNode(2, cycleEnd);

    return Stream.of(
        Arguments.of(
            new ListNode(1),
            false
        ),
        Arguments.of(
            new ListNode(1, new ListNode(2)),
            false
        ),
        Arguments.of(
            new ListNode(0, cycleStart),
            true
        )
    );
  }

  @MethodSource("getArgs")
  @ParameterizedTest
  void hasCycle(ListNode givenList, boolean expectedResult) {
    assertThat(new LinkedListCycle().hasCycle(givenList)).isEqualTo(expectedResult);
  }
}