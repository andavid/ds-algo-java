package com.github.andavid.ds.datastructure.heap;

import java.util.Arrays;

import org.junit.Test;

public class TopkTest {

  @Test
  public void testTopk() {
    int[] data = {1,2,3,4,5,6,7,8,9,10};
    Topk topk = new Topk();
    int[] result = topk.topk(data, 5);
    System.out.println(Arrays.toString(result));
  }

}