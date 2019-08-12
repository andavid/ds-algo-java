package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class CircularLinkedListTest {

  @Test
  public void testCircularLinkedList() {
    CircularLinkedList list = new CircularLinkedList();
    list.print();

    list.insertHead(1);
    list.print();

    list.insertHead(2);
    list.insertTail(3);
    list.print();

    list.deleteHead();
    list.print();

    list.deleteTail();
    list.print();
  }
}
