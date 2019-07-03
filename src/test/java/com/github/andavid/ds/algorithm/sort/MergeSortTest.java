package com.github.andavid.ds.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {
  @Test
  public void testMergeSort() {
    MergeSort mergeSort = new MergeSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before merge sort: " + Arrays.toString(data));
    mergeSort.sort(data);
    System.out.println("after merge sort: " + Arrays.toString(data));
  }
}