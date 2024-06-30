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
}
