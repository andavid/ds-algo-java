package com.github.andavid.ds.algorithm.divideandconquer;

import org.junit.Test;

public class CountInversePairsTest {

  @Test
  public void testCountInversePairs() {
    CountInversePairs instance = new CountInversePairs();
    int[] data1 = {7, 5, 6, 4};
    System.out.println(instance.count(data1));

    int[] data2 = {5, 6, 7, 8, 1, 2, 3, 4};
    System.out.println(instance.count(data2));

    int[] data3 = {4, 3, 11, 15, 13, 2, 8};
    System.out.println(instance.count(data3));
  }
}
