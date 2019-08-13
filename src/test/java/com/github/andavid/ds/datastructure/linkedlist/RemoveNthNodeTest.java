package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class RemoveNthNodeTest {

  @Test
  public void testRemoveNthNode() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    System.out.println(head);

    RemoveNthNode instance = new RemoveNthNode();
    ListNode node = instance.removeNthFromEnd(head, 1);
    System.out.println(node);

    node = instance.removeNthFromEnd(node, 2);
    System.out.println(node);

    node = instance.removeNthFromEnd(node, 2);
    System.out.println(node);
  }
}
