package com.denisvlem.linked;

/**
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/description/"/>
 */
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    ListNode oneStep = head;
    ListNode doubleStep = head;

    while (doubleStep != null && doubleStep.next != null) {
      oneStep = oneStep.next;
      doubleStep = doubleStep.next.next;
      if (oneStep == doubleStep) {
        return true;
      }
    }
    return false;
  }
}
