package com.github.andavid.ds.datastructure.linkedlist;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (ListNode p = this; p != null; p = p.next) {
      sb.append(p.val);
      if (p.next != null) {
        sb.append(",").append(" ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
