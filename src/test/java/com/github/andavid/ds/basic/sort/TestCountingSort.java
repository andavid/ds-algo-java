package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestCountingSort {

  @Test
  public void testCountingSort() {
    CountingSort countingSort = new CountingSort();
    int[] data = {2,5,3,0,2,3,0,3};
    System.out.println("before counting sort: " + Arrays.toString(data));
    countingSort.sort(data);
    System.out.println("before counting sort: " + Arrays.toString(data));
  }
}