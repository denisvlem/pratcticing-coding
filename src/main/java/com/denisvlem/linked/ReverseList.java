package com.denisvlem.linked;

/**
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/description/"/>
 */
public class ReverseList {

  public ListNode reverseList(ListNode head) {
    var current = head;
    ListNode prev = null;

    while (null != current) {
      var next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }
}
