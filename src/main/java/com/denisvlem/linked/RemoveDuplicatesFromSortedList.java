package com.denisvlem.linked;

/**
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/"/>
 */
public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (null != current && null != current.next) {
      while (null != current.next && current.val == current.next.val) {
        current.next = current.next.next;
      }
      current = current.next;
    }
    return head;
  }

}
