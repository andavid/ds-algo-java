package com.github.andavid.ds.algorithm.sort;

import org.junit.Test;

public class FindKthLargestTest {

  @Test
  public void testFindKthLargest() {
    FindKthLargest instance = new FindKthLargest();
    int[] data = {3,2,1,5,6,4};
    System.out.println(instance.findKthLargest(data, 2));
  }
}