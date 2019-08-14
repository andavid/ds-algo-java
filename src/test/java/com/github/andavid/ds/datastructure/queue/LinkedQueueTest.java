package com.github.andavid.ds.datastructure.queue;

import org.junit.Test;

public class LinkedQueueTest {

  @Test
  public void testLinkedQueue() {
    LinkedQueue queue = new LinkedQueue();
    System.out.println(queue);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    System.out.println(queue);

    queue.dequeue();
    queue.dequeue();
    System.out.println(queue);

    queue.dequeue();
    queue.dequeue();
    System.out.println(queue);

    queue.dequeue();
  }
}
