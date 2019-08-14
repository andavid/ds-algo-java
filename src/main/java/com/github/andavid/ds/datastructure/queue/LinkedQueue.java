package com.github.andavid.ds.datastructure.queue;

import com.github.andavid.ds.datastructure.linkedlist.ListNode;

public class LinkedQueue {
  ListNode head;
  ListNode tail;

  public void enqueue(int value) {
    ListNode newNode = new ListNode(value);
    if (tail == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public int dequeue() {
    if (head == null) {
      throw new IllegalArgumentException("queue empty");
    }

    int value = head.val;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    return value;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (ListNode p = head; p != null; p = p.next) {
      sb.append(p.val);
      if (p.next != null) {
        sb.append(",").append(" ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
