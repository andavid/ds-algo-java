package com.github.andavid.ds.datastructure.array;

import org.junit.Test;

public class SortedArrayTest {

  @Test
  public void testSortedArray() {
    SortedArray array = new SortedArray(5);
    array.add(3);
    array.add(1);
    array.add(5);
    array.add(2);
    array.add(4);
    System.out.println(array);

    array.remove(2);
    System.out.println(array);

    array.add(6);
    array.add(7);
  }

}
