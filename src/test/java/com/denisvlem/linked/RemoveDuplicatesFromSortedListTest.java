package com.denisvlem.linked;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedListTest {

  @Test
  void deleteDuplicates() {
    var list = new ListNode(1, new ListNode(1, new ListNode(2)));

    var newList = new RemoveDuplicatesFromSortedList().deleteDuplicates(list);
    assertThat(newList).hasToString("1 2");
  }
}