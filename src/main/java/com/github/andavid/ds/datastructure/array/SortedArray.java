package com.github.andavid.ds.datastructure.array;

/**
 * 实现一个大小固定的有序数组
 */
public class SortedArray {

  /**
   * 默认容量
   */
  public static final int DEFAULT_CAPACITY = 20;

  int capacity;
  int size;
  int[] data;

  public SortedArray() {
    this(DEFAULT_CAPACITY);
  }

  public SortedArray(int initialCapacity) {
    capacity = initialCapacity;
    data = new int[capacity];
  }

  /**
   * 添加元素
   */
  public void add(int element) {
    if (size == capacity) {
      throw new IllegalArgumentException("add fail. array is full.");
    }

    int i = size - 1;
    for (; i >= 0; i--) {
      if (element < data[i]) {
        data[i + 1] = data[i];
      } else {
        break;
      }
    }
    data[i + 1] = element;
    size++;
  }

  /**
   * 删除指定索引的元素
   */
  public int remove(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("remove fail. index out of range.");
    }

    int element = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    data[size - 1] = 0;
    size--;

    return element;
  }

  public int get(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("get fail. index out of range.");
    }
    return data[index];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

  public String toString() {
    if (isEmpty()) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size; i++) {
      sb.append(get(i));
      if (i == size - 1) {
        sb.append("]");
      } else {
        sb.append(',').append(' ');
      }
    }

    return sb.toString();
  }
}
