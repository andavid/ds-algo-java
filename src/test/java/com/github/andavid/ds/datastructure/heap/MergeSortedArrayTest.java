package com.github.andavid.ds.datastructure.heap;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArrayTest {

  @Test
  public void testMergeSortedArray() {
    MergeSortedArray instance = new MergeSortedArray();
    int[][] array = {{1,3,5,7},{2,4,6},{8,9,10}};
    int[] result = instance.mergeSortedArray(array);
    System.out.println(Arrays.toString(result));
  }
}