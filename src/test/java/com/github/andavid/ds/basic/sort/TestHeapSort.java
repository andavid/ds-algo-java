package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestHeapSort {

  @Test
  public void testHeapSort() {
    HeapSort heapSort = new HeapSort();
    int[] data = {8,2,5,9,7,3};
    System.out.println("before heap sort: " + Arrays.toString(data));
    heapSort.sort(data);
    System.out.println("after heap sort: " + Arrays.toString(data));
  }
}