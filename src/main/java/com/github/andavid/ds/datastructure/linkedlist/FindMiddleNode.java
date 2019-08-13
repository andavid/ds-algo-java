package com.github.andavid.ds.datastructure.linkedlist;

public class FindMiddleNode {

  /**
   * 返回链表中间节点。
   * 如果链表有偶数个节点，那么中间节点有两个，返回后面的那个节点。
   */
  public ListNode findMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
