package com.denisvlem.linked;

import java.util.Objects;

public class ListNode {

  final int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ListNode listNode = (ListNode) o;

    if (val != listNode.val) {
      return false;
    }
    return Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    int result = val;
    result = 31 * result + (next != null ? next.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    var builder = new StringBuilder();
    var current = this;
    while (current != null) {
      builder.append(current.val).append(" ");
      current = current.next;
    }

    return builder.toString().trim();
  }
}
