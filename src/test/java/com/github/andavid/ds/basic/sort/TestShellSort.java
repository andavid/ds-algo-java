package com.github.andavid.ds.basic.sort;

import java.util.Arrays;

import org.junit.Test;

public class TestShellSort {

  @Test
  public void testShellSort() {
    ShellSort shellSort = new ShellSort();
    int[] data = {9,8,7,6,5,4,3,2,1};
    System.out.println("before shell sort: " + Arrays.toString(data));
    shellSort.sort(data);
    System.out.println("after shell sort: " + Arrays.toString(data));
  }

}