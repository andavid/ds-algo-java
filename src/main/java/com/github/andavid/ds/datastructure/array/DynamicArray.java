package com.github.andavid.ds.datastructure.array;

/**
 * 实现一个支持动态扩容的数组
 */
public class DynamicArray {

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
   * 当前数据个数
   */
  int size;

  /**
   * 数组容器
   */
  int[] table;

  public DynamicArray(int initialCapacity) {
    capacity = initialCapacity;
    table = new int[capacity];
  }

  public DynamicArray() {
    this(DEAFAULT_CAPACITY);
  }

  /**
   * 添加元素
   */
  public void add(int value) {
    if (size == capacity - 1) {
      resize();
    }
    if (size < capacity) {
      table[size++] = value;
    }
  }

  /**
   * 删除指定索引元素
   * @param index
   */
  public void remove(int index) {
    if (isValid(index)) {
      if (index == size - 1) {
        // 删除最末尾的元素
        table[index] = 0;
      } else {
        for (int i = index; i < size - 1; i++) {
          table[i] = table[i + 1];
        }
      }
      size--;
    } else {
      throw new IllegalArgumentException("index out of range");
    }
  }

  public int get(int index) {
    if (isValid(index)) {
      return table[index];
    } else {
      throw new IllegalArgumentException("index out of range");
    }
  }

  public void set(int index, int value) {
    if (isValid(index)) {
      table[index] = value;
    } else {
      throw new IllegalArgumentException("index out of range");
    }
  }

  public boolean isValid(int index) {
    return index >= 0 && index < size;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public int getSize() {
    return size;
  }

  public void resize() {
    if (capacity < MAX_CAPACITY) {
      capacity = Math.min(2 * capacity, MAX_CAPACITY);
      int[] newTable = new int[capacity];
      for (int i = 0; i < size; i++) {
        newTable[i] = table[i];
      }
      table = newTable;
    }
  }

}
