package com.github.andavid.ds.datastructure.queue;

import java.util.Queue;
import java.util.LinkedList;

public class QueueUsage {
  public static void main(String[] args) {
    // 1. Initialize a queue.
    Queue<Integer> q = new LinkedList<>();
    // 2. Get the first element - return null if queue is empty.
    System.out.println("The first element is: " + q.peek());
    // 3. Push new element.
    q.offer(5);
    q.offer(13);
    q.offer(8);
    q.offer(6);
    // 4. Pop an element.
    q.poll();
    // 5. Get the first element.
    System.out.println("The first element is: " + q.peek());
    // 7. Get the size of the queue.
    System.out.println("The size is: " + q.size());
    // 8. Check if queue is empty.
    System.out.println("The queue is empty: " + q.isEmpty());
  }
}