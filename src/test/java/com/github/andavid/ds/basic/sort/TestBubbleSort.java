package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestBubbleSort {

  @Test
  public void testBubbleSort() {
    BubbleSort bubbleSort = new BubbleSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before sort: " + Arrays.toString(data));
    bubbleSort.sort(data);
    System.out.println("after sort: " + Arrays.toString(data));
  }
}