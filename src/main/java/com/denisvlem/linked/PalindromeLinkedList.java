package com.denisvlem.linked;

import java.util.LinkedList;

public class PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {

    var stack = new LinkedList<Integer>();
    var current = head;

    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }

    current = head;
    var isPalindrome = true;
    while (current != null && isPalindrome) {
      isPalindrome = current.val == stack.pop();
      current = current.next;
    }

    return isPalindrome;
  }

  public boolean isPalindrome2(ListNode head) {

    ListNode singleStep = head;
    ListNode doubleStep = head;
    ListNode prev = null;

    while (doubleStep != null && doubleStep.next != null) {
      doubleStep = doubleStep.next.next;
      var tmp = singleStep.next;
      singleStep.next = prev;
      prev = singleStep;
      singleStep = tmp;
    }

    if (doubleStep != null) {
      singleStep = singleStep.next;
    }

    var isPalindrome = true;
    while (prev != null && singleStep != null && isPalindrome) {
      isPalindrome = prev.val == singleStep.val;

      prev = prev.next;
      singleStep = singleStep.next;
    }

    return isPalindrome;
  }
}
