package com.denisvlem.linked;

/**
 * 876. Middle of the Linked List
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/description/"/>
 */
public class MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    var oneStepPointer = head;
    var twoStepPointer = head;

    while (null != twoStepPointer && null != twoStepPointer.next) {
      twoStepPointer = twoStepPointer.next.next;
      oneStepPointer = oneStepPointer.next;
    }

    return oneStepPointer;
  }

}
