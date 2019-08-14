package com.github.andavid.ds.datastructure.stack;

import com.github.andavid.ds.datastructure.linkedlist.ListNode;

public class LinkedStack {
  private ListNode head;
  private int count;

  public LinkedStack() {
    head = null;
    count = 0;
  }

  public int push(int item) {
    ListNode newNode = new ListNode(item);
    newNode.next = head;
    head = newNode;
    count++;
    return item;
  }

  public int pop() {
    if (count == 0) {
      throw new IllegalArgumentException("Stack empty");
    }

    int obj = head.val;
    head = head.next;
    count--;

    return obj;
  }

  public int peek() {
    if (count == 0) {
      throw new IllegalArgumentException("Stack empty");
    }

    int obj = head.val;
    return obj;
  }

  public boolean empty() {
    return size() == 0;
  }

  public int size() {
    return count;
  }
}
