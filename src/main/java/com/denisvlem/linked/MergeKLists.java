package com.denisvlem.linked;

public class MergeKLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }

    var middle = (start + end) / 2;
    ListNode left = merge(lists, start, middle);
    ListNode right = merge(lists, middle + 1, end);

    return merge(left, right);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode newHead = null;
    ListNode current = null;

    while (left != null || right != null) {
      ListNode next;
      if (left != null && right != null) {
        if (left.val < right.val) {
          next = left;
          left = left.next;
        } else {
          next = right;
          right = right.next;
        }
      } else if (left != null) {
        next = left;
        left = left.next;
      } else {
        next = right;
        right = right.next;
      }

      if (newHead == null) {
        newHead = next;
        current = newHead;
      } else {
        current.next = next;
        current = current.next;
      }
    }
    return newHead;
  }
}
