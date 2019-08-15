package com.github.andavid.ds.datastructure.queue;

public class CircularQueue {
  private String[] items;
  private int n = 0;
  private int head = 0;
  private int tail = 0;

  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  public boolean enqueue(String item) {
    if ((tail + 1) % n == head) {
      // 队满，tail 指向的位置不存储数据，实际存储的数据个数为 n-1
      return false;
    }
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  public String dequeue() {
    if (head == tail) {
      // 队空
      return null;
    }
    String item = items[head];
    head = (head + 1) % n;
    return item;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = head; i % n != tail; i++) {
      sb.append(items[i]);
      if ((i + 1) % n != tail) {
        sb.append(",").append(" ");
      }
    }
    sb.append("]");
    return sb.toString();
  }
}
