package com.github.andavid.ds.datastructure.linkedlist;

/**
 * 删除链表倒数第 N 个节点
 */
public class RemoveNthNode {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;

    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
  }
}
