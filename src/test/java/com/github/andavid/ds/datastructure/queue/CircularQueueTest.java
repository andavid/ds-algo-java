package com.github.andavid.ds.datastructure.queue;

import org.junit.Test;

public class CircularQueueTest {

  @Test
  public void testCircularQueue() {
    CircularQueue queue = new CircularQueue(5);
    System.out.println(queue);

    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");
    queue.enqueue("e");
    queue.enqueue("f");
    System.out.println(queue);

    queue.dequeue();
    queue.dequeue();
    System.out.println(queue);
  }
}
