package com.github.andavid.ds.basic.search;

import org.junit.Test;

public class TestBinarySearch {

  private BinarySearch search = new BinarySearch();

  @Test
  public void testBinarySearch() {
    int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < data.length; i++) {
      int index = search.bsearch(data, data[i]);
      System.out.println("查找元素 " + data[i] + " 的索引为: " + index);
    }
  }

  @Test
  public void testBinarySearchRecursion() {
    int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < data.length; i++) {
      int index = search.bsearchRecursion(data, data[i]);
      System.out.println("查找元素 " + data[i] + " 的索引为: " + index);
    }
  }

  @Test
  public void testBinarySearchFirst() {
    int[] data = new int[] {0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10};
    int value = 4;
    int index = search.bsearchFirst(data, value);
    System.out.println("查找第一个值等于 " + value + " 的索引为 " + index);
  }

  @Test
  public void testBinarySearchLast() {
    int[] data = new int[] {0, 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10};
    int value = 4;
    int index = search.bsearchLast(data, value);
    System.out.println("查找最后一个值等于 " + value + " 的索引为 " + index);
  }

  @Test
  public void testBinarySearchFirstGreater() {
    int[] data = new int[] {3, 4, 6, 7, 10};
    int value = 5;
    int index = search.bsearchFirstGreater(data, value);
    System.out.println("查找第一个值大于等于 " + value + " 的索引为 " + index);
  }

  @Test
  public void testBinarySearchLastLess() {
    int[] data = new int[] {3, 5, 6, 8, 9, 10};
    int value = 7;
    int index = search.bsearchLastLess(data, value);
    System.out.println("查找最后一个值小于等于 " + value + " 的索引为 " + index);
  }

}