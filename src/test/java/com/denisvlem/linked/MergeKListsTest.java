package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MergeKListsTest {

  static Stream<Arguments> getArgs() {
    return Stream.of(
        Arguments.of(new ListNode[]{
            new ListNode(1, new ListNode(3)),
            new ListNode(2, new ListNode(4))
        }, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))))
    );
  }

  private final MergeKLists solution = new MergeKLists();

  @ParameterizedTest
  @MethodSource("getArgs")
  void testMergeKLists(ListNode[] listNodes, ListNode expectedResult) {
    assertThat(solution.mergeKLists(listNodes)).hasToString(expectedResult.toString());
  }

}