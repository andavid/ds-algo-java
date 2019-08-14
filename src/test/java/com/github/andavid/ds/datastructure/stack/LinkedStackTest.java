package com.github.andavid.ds.datastructure.stack;

import org.junit.Test;

public class LinkedStackTest {

  @Test
  public void testLinkedStack() {
    LinkedStack stack = new LinkedStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.size());
  }
}
