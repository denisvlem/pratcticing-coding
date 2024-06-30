package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PalindromeLinkedListTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), false),
        Arguments.of(new ListNode(1, new ListNode(1)), true),
        Arguments.of(new ListNode(1), true)
    );
  }

  @MethodSource("getArgs")
  @ParameterizedTest
  void isPalindrome(ListNode givenList, boolean expectedResult) {
    assertThat(new PalindromeLinkedList().isPalindrome(givenList)).isEqualTo(expectedResult);
  }
}