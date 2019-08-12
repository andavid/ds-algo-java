package com.github.andavid.ds.datastructure.linkedlist;

public class CircularLinkedList {
  ListNode head = null;
  ListNode tail = null;

  public void insertHead(int value) {
    ListNode newNode = new ListNode(value);
    insertHead(newNode);
  }

  public void insertHead(ListNode newNode) {
    if (head == null) {
      newNode.next = newNode;
      head = tail = newNode;
    } else {
      newNode.next = head;
      tail.next = newNode;
      head = newNode;
    }
  }

  public void insertTail(int value) {
    ListNode newNode = new ListNode(value);
    insertTail(newNode);
  }

  public void insertTail(ListNode newNode) {
    if (head == null) {
      newNode.next = newNode;
      head = tail = newNode;
    } else {
      newNode.next = head;
      tail.next = newNode;
      tail = newNode;
    }
  }

  public void deleteHead() {
    if (head == null) {
      return;
    }

    if (head == tail) {
      head = tail = null;
      return;
    }

    head = head.next;
    tail.next = head;
  }

  public void deleteTail() {
    if (tail == null) {
      return;
    }

    if (head == tail) {
      head = tail = null;
      return;
    }

    ListNode p = head;
    while (p.next != tail) {
      p = p.next;
    }
    p.next = head;
    tail = p;
  }

  public void print() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (ListNode p = head; p != null; p = p.next) {
      sb.append(p.val);
      if (p.next != head) {
        sb.append(",").append(" ");
      } else {
        break;
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }
}
