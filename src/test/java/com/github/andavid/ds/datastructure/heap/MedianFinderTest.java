package com.github.andavid.ds.datastructure.heap;

import org.junit.Test;

public class MedianFinderTest {

  @Test
  public void testMedianFinder() {
    MedianFinder median = new MedianFinder();
    median.addNum(1);
    median.addNum(2);
    median.addNum(3);
    median.addNum(4);
    System.out.println(median.findMedian());
  }
}