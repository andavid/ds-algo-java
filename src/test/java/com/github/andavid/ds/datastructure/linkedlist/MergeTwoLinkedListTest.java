package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class MergeTwoLinkedListTest {

  @Test
  public void testMergeTwoLinkedList() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);
    System.out.println(l1);

    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(4);
    l2.next.next = new ListNode(6);
    System.out.println(l2);

    MergeTwoLinkedList instance = new MergeTwoLinkedList();
    ListNode node = instance.mergeTwoLists(l1, l2);
    System.out.println(node);
  }

  @Test
  public void testMergeTwoLinkedListRecursively() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);
    System.out.println(l1);

    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(4);
    l2.next.next = new ListNode(6);
    System.out.println(l2);

    MergeTwoLinkedList instance = new MergeTwoLinkedList();
    ListNode node = instance.mergeTwoListsRecursively(l1, l2);
    System.out.println(node);
  }
}
