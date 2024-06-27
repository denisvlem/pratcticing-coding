package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MiddleOfTheLinkedListTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(
            new ListNode(1),
            new ListNode(1)
        ),
        Arguments.of(
            new ListNode(1, new ListNode(2, new ListNode(3))),
            new ListNode(2, new ListNode(3))
        ),
        Arguments.of(
            new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
            new ListNode(3, new ListNode(4))
        ), Arguments.of(
            null,
            null
        )
    );
  }

  @ParameterizedTest
  @MethodSource("getArgs")
  void middleNode(ListNode givenListHead, ListNode expectedMiddleNode) {

    assertThat(new MiddleOfTheLinkedList().middleNode(givenListHead)).isEqualTo(expectedMiddleNode);
  }
}