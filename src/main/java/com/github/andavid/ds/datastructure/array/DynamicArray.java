package com.github.andavid.ds.datastructure.array;

/**
 * 实现一个支持动态扩容的数组
 */
public class DynamicArray<E> {

  /**
   * 默认容量
   */
  public static final int DEAFAULT_CAPACITY = 10;

  /**
   * 最大容量
   */
  public static final int MAX_CAPACITY = Integer.MAX_VALUE;

  /**
   * 当前容量
   */
  int capacity;

  /**
   * 当前元素个数
   */
  int size;

  /**
   * 数组容器
   */
  E[] table;

  public DynamicArray() {
    this(DEAFAULT_CAPACITY);
  }

  public DynamicArray(int initialCapacity) {
    capacity = initialCapacity;
    table = (E[]) new Object[capacity];
  }

  public void add(E e) {
    addLast(e);
  }

  public void addFirst(E e) {
    addElement(0, e);
  }

  public void addLast(E e) {
    addElement(size, e);
  }

  public void addElement(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("add fail. index out of range.");
    }

    if (size == MAX_CAPACITY) {
      throw new IllegalArgumentException("add fail. exceed max capacity.");
    }

    resize();

    for (int i = size - 1; i >= index; i--) {
      table[i + 1] = table[i];
    }
    table[index] = e;
    size++;
  }

  public E remove() {
    return removeLast();
  }

  public E removeFirst() {
    return removeElement(0);
  }

  public E removeLast() {
    return removeElement(size - 1);
  }

  public E removeElement(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("remove fail. index out of range.");
    }

    E element = table[index];
    for (int i = index; i < size - 1; i++) {
      table[i] = table[i + 1];
    }
    table[size - 1] = null;
    size--;

    resize();

    return element;
  }

  /**
   * 获取元素
   */
  public E get(int index) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("get fail. index out of range.");
    }
    return table[index];
  }

  /**
   * 根据索引设置元素值
   */
  public void set(int index, E value) {
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("set fail. index out of range.");
    }
    table[index] = value;
  }

  /**
   * 判断数组是否为空
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * 获取当前数组元素个数
   */
  public int getSize() {
    return size;
  }

  /**
   * 获取当前数组容量
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * 数组扩容
   */
  public void resize() {
    int oldCapacity = capacity;

    // 扩容
    if (size == capacity) {
      // 容量已满，容量扩大一倍
      if (capacity > MAX_CAPACITY / 2) {
        capacity = MAX_CAPACITY;
      } else {
        capacity = capacity * 2;
      }
    }

    // 缩容
    if (size <= capacity / 4 && capacity / 2 != 0) {
      // 当实际元素个数小于等于容量的四分之一时，将容量缩小为原来的一半
      capacity = capacity / 2;
    }

    if (capacity != oldCapacity) {
      E[] newTable = (E[]) new Object[capacity];
      System.arraycopy(table, 0, newTable, 0, size);
      table = newTable;
    }
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
