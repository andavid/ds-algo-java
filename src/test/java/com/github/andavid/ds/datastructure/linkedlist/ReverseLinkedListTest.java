package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class ReverseLinkedListTest {

  @Test
  public void testReverseLinkedList() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    System.out.println(head);

    ReverseLinkedList instance = new ReverseLinkedList();
    ListNode node = instance.reverseList(head);
    System.out.println(node);

    node = instance.reverseListRecursively(node);
    System.out.println(node);
  }
}
