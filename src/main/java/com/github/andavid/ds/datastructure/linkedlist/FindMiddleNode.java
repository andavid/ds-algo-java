package com.github.andavid.ds.datastructure.linkedlist;

public class FindMiddleNode {
  public ListNode findMiddleNode(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }
}
