package com.github.andavid.ds.datastructure.linkedlist;

import org.junit.Test;

public class FindMiddleNodeTest {

  @Test
  public void testFindMiddleNode() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    System.out.println(head);

    FindMiddleNode instance = new FindMiddleNode();
    ListNode middleNode = instance.findMiddleNode(head);
    System.out.println(middleNode.val);
  }
}
