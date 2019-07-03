package com.github.andavid.ds.algorithm.sort;

import java.util.Arrays;

import org.junit.Test;

public class BucketSortTest {

  @Test
  public void testBucketSort() {
    BucketSort bucketSort = new BucketSort();
    int[] data = {22,5,11,41,45,26,29,10,7,8,30,27,42,43,40};
    System.out.println("before bucket sort: " + Arrays.toString(data));
    bucketSort.sort(data);
    System.out.println("after bucket sort: " + Arrays.toString(data));
  }

}