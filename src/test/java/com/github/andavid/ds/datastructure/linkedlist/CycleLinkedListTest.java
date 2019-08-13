package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class CycleLinkedListTest {

  @Test
  public void testCycleLinkedList() {
    ListNode head = new ListNode(0);
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);

    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;

    CycleLinkedList instance = new CycleLinkedList();
    System.out.println("链表是否有环: " + instance.hasCycle(head));
    System.out.println("链表入口节点: " + instance.getCycleEntryNode(head).val);
    System.out.println("链表环的长度: " + instance.getCycleLength(head));
  }
}
