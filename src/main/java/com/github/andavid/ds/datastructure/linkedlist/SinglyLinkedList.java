package com.github.andavid.ds.datastructure.linkedlist;

public class SinglyLinkedList {
  ListNode head = null;

  public void insertHead(int value) {
    ListNode newNode = new ListNode(value);
    insertHead(newNode);
  }

  public void insertHead(ListNode newNode) {
    if (head == null) {
      head = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  public void insertTail(int value) {
    ListNode newNode = new ListNode(value);
    insertTail(newNode);
  }

  public void insertTail(ListNode newNode) {
    if (head == null) {
      head = newNode;
    } else {
      ListNode p = head;
      while (p.next != null) {
        p = p.next;
      }
      p.next = newNode;
    }
  }

  public void insertAfter(ListNode p, int value) {
    ListNode newNode = new ListNode(value);
    insertAfter(p, newNode);
  }

  public void insertAfter(ListNode p, ListNode newNode) {
    if (p == null) {
      return;
    }
    newNode.next = p.next;
    p.next = newNode;
  }

  public void insertBefore(ListNode p, int value) {
    ListNode newNode = new ListNode(value);
    insertBefore(p, newNode);
  }

  public void insertBefore(ListNode p, ListNode newNode) {
    if (p == null) {
      return;
    }
    if (p == head) {
      insertHead(newNode);
    }
    ListNode q = head;
    while (q != null && q.next != p) {
      q = q.next;
    }
    if (q == null) {
      return;
    }
    newNode.next = p;
    q.next = newNode;
  }

  public void delete(ListNode p) {
    if (p == null || head == null) {
      return;
    }

    if (p == head) {
      head = head.next;
      return;
    }

    ListNode q = head;
    while (q != null && q.next != p) {
      q = q.next;
    }

    if (q == null) {
      return;
    }

    q.next = q.next.next;
  }

  public void deleteFirst(int value) {
    if (head == null) {
      return;
    }

    if (value == head.val) {
      head = head.next;
      return;
    }

    ListNode p = head;
    while (p.next != null && p.next.val != value) {
      p = p.next;
    }

    if (p.next == null) {
      return;
    }

    p.next = p.next.next;
  }

  public void deleteAll(int value) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode p = dummy;
    while (p.next != null) {
      if (p.next.val == value) {
        p.next = p.next.next;
        continue;
      }
      p = p.next;
    }
    head = dummy.next;
  }

  public void print() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (ListNode p = head; p != null; p = p.next) {
      sb.append(p.val);
      if (p.next != null) {
        sb.append(",").append(" ");
      }
    }
    sb.append("]");
    System.out.println(sb.toString());
  }

}
