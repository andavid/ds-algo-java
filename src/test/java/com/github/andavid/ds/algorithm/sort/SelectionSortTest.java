package com.github.andavid.ds.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSortTest {

  @Test
  public void testBubbleSort() {
    SelectionSort selectionSort = new SelectionSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before selection sort: " + Arrays.toString(data));
    selectionSort.sort(data);
    System.out.println("after selection sort: " + Arrays.toString(data));
  }
}