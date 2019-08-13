package com.github.andavid.ds.datastructure.linkedlist;

public class CycleLinkedList {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  /**
   * 返回第一个进入环的节点。
   * 从头节点和快慢指针碰撞节点出发，相遇的节点就是入口节点。
   */
  public ListNode getCycleEntryNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }

    return null;
  }

  /**
   * 求链表环的长度。
   * 快慢指针从相遇节点开始，再次相遇时，慢指针走过的距离就是环的长度。
   */
  public int getCycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int len = 0;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        do {
          len++;
          slow = slow.next;
          fast = fast.next.next;
        } while (slow != fast);
        return len;
      }
    }

    return 0;
  }
}
