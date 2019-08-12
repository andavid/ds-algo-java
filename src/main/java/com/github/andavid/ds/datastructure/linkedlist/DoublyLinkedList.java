package com.github.andavid.ds.datastructure.linkedlist;

public class DoublyLinkedList {

  class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  Node head = null;
  Node tail = null;

  public void insertHead(int value) {
    Node newNode = new Node(value);
    insertHead(newNode);
  }

  public void insertHead(Node newNode) {
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
  }

  public void insertTail(int value) {
    Node newNode = new Node(value);
    insertTail(newNode);
  }

  public void insertTail(Node newNode) {
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.prev = tail;
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
  }

  public void deleteTail() {
    if (head == null) {
      return;
    }

    if (head == tail) {
      head = tail = null;
      return;
    }

    tail = tail.prev;
  }

  public void print() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Node p = head; p != null; p = p.next) {
      sb.append(p.val);
      if (p != tail) {
        sb.append(",").append(" ");
      } else {
        break;
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

  public void reversePrint() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Node p = tail; p != null; p = p.prev) {
      sb.append(p.val);
      if (p != head) {
        sb.append(",").append(" ");
      } else {
        break;
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }
}
