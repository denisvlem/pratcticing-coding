package com.denisvlem.linked;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/description/">
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
    var result = new ListNode(0);
    var previous = result;
    var tenRange = 0;

    while (n1 != null || n2 != null || tenRange != 0) {
      var sum = tenRange;

      sum += n1 != null ? n1.val : 0;
      sum += n2 != null ? n2.val : 0;

      var smallRange = sum % 10;
      tenRange = sum / 10;

      result.next = new ListNode(smallRange);
      result = result.next;

      n1 = n1 != null ? n1.next : null;
      n2 = n2 != null ? n2.next : null;
    }

    return previous.next;
  }

}
