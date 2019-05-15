package com.github.andavid.ds.basic.sort;

import org.junit.Test;

public class TestQuickSort {

  @Test
  public void testQuickSort() {
    QuickSort quickSort = new QuickSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    quickSort.print(data);
    quickSort.sort(data);
    quickSort.print(data);
  }
}