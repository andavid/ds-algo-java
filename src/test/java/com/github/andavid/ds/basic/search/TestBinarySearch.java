package com.github.andavid.ds.basic.search;

import org.junit.Test;

public class TestBinarySearch {

  private BinarySearch searchInstance = new BinarySearch();

  @Test
  public void testBinarySearch() {
    int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < data.length; i++) {
      int index = searchInstance.bsearch(data, data[i]);
      System.out.println("查找元素 " + data[i] + " 的索引为: " + index);
    }
  }

  @Test
  public void testBinarySearchRecursion() {
    int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < data.length; i++) {
      int index = searchInstance.bsearchRecursion(data, data[i]);
      System.out.println("查找元素 " + data[i] + " 的索引为: " + index);
    }
  }

}