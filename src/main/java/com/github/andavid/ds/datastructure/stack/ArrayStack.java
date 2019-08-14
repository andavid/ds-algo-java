package com.github.andavid.ds.datastructure.stack;

public class ArrayStack {
  private int[] data;
  private int count;

  public ArrayStack() {
    this(10);
  }

  public ArrayStack(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }

    data = new int[initialCapacity];
  }

  public int push(int item) {
    if (count == data.length) {
      throw new IllegalArgumentException("Stack full");
    }

    data[count++] = item;
    return item;
  }

  public int pop() {
    if (count == 0) {
      throw new IllegalArgumentException("Stack empty");
    }

    int obj = data[count - 1];
    count--;

    return obj;
  }

  public int peek() {
    if (count == 0) {
      throw new IllegalArgumentException("Stack empty");
    }

    return data[count - 1];
  }

  public boolean empty() {
    return size() == 0;
  }

  public int size() {
    return count;
  }
}
