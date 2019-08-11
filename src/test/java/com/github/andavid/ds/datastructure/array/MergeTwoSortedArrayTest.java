package com.github.andavid.ds.datastructure.array;

import java.util.Arrays;
import org.junit.Test;

public class MergeTwoSortedArrayTest {

  @Test
  public void testMerge() {
    MergeTwoSortedArray array = new MergeTwoSortedArray();
    int[] arr1 = {1, 3, 5, 7};
    int[] arr2 = {2, 4, 6, 8};
    int[] arr = array.mergeTwoSortedArray(arr1, arr2);
    System.out.println(Arrays.toString(arr));
  }

}
