package com.github.andavid.ds.datastructure.linkedlist;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public ListNode reverseListRecursively(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode node = reverseListRecursively(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }
}
