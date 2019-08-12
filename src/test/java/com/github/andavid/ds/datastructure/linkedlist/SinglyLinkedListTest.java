package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class SinglyLinkedListTest {

  @Test
  public void testSinglyLinkedTest() {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insertHead(1);
    list.insertTail(2);
    ListNode node = new ListNode(4);
    list.insertTail(node);
    list.insertBefore(node, 3);
    list.insertAfter(node, 5);
    list.print();

    list.delete(node);
    list.deleteFirst(5);
    list.print();

    list.insertTail(2);
    list.print();

    list.deleteAll(2);
    list.print();
  }
}
