package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestQuickSort {

  @Test
  public void testQuickSort() {
    QuickSort quickSort = new QuickSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before quick sort: " + Arrays.toString(data));
    quickSort.sort(data);
    System.out.println("before quick sort: " + Arrays.toString(data));
  }
}