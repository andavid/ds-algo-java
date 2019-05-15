package com.github.andavid.ds.basic.sort;

import org.junit.Test;

public class TestMergeSort {
  @Test
  public void testMergeSort() {
    MergeSort mergeSort = new MergeSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    mergeSort.print(data);
    mergeSort.sort(data);
    mergeSort.print(data);
  }
}