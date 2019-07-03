package com.github.andavid.ds.datastructure.queue;

public class ArrayQueue {
  private String[] items;
  private int n = 0;
  private int head = 0;
  private int tail = 0;

  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  public boolean enqueue(String item) {
    if (tail == n) {
      return false;
    }
    items[tail++] = item;
    return true;
  }

  public String dequeue() {
    if (head == tail) {
      return null;
    }
    return items[head++];
  }

  public void printAll() {
    for (int i = head; i < tail; i++) {
      System.out.println(items[i] + " ");
    }
    System.out.println();
  }
}