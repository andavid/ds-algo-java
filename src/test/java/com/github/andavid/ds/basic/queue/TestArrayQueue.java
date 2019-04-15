package com.github.andavid.ds.basic.queue;

import org.junit.Test;

public class TestArrayQueue {

  @Test
  public void testArrayQueue() {
    ArrayQueue queue = new ArrayQueue(5);
    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");
    queue.enqueue("e");
    queue.enqueue("f");
    queue.dequeue();
    queue.printAll();
  }
}