package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class DoublyLinkedListTest {

  @Test
  public void testDoublyLinkedList() {
    DoublyLinkedList list = new DoublyLinkedList();
    list.print();

    list.insertHead(1);
    list.print();

    list.insertHead(2);
    list.insertTail(3);
    list.insertTail(4);
    list.print();
    list.reversePrint();

    list.deleteHead();
    list.print();

    list.deleteTail();
    list.print();

    list.deleteHead();
    list.deleteTail();
    list.print();
  }
}
