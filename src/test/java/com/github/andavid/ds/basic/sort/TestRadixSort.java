package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestRadixSort {

  @Test
  public void testRadixSort() {
    RadixSort radixSort = new RadixSort();
    int[] data = {892,846,821,199,810,700};
    System.out.println("before radix sort: " + Arrays.toString(data));
    radixSort.sort(data);
    System.out.println("after radix sort: " + Arrays.toString(data));
  }

}