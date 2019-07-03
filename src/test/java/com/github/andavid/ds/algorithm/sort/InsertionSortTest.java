package com.github.andavid.ds.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSortTest {

  @Test
  public void testInsertionSort() {
    InsertionSort insertionSort = new InsertionSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before insertion sort: " + Arrays.toString(data));
    insertionSort.sort(data);
    System.out.println("after insertion sort: " + Arrays.toString(data));
  }
}