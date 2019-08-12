package com.github.andavid.ds.datastructure.linkedlist;

public class MergeTwoLinkedList {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        p.next = l2;
        break;
      }
      if (l2 == null) {
        p.next = l1;
        break;
      }
      if (l1.val <= l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }

    return dummy.next;
  }

  public ListNode mergeTwoListsRecursively(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val <= l2.val) {
      l1.next = mergeTwoListsRecursively(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListsRecursively(l1, l2.next);
      return l2;
    }
  }

}
