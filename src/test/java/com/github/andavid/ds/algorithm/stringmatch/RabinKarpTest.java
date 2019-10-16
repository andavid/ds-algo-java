package com.github.andavid.ds.algorithm.stringmatch;

import org.junit.Test;

public class RabinKarpTest {

  @Test
  public void testRabinKarp() {
    String pattern = "y similar t";
    RabinKarp rk = new RabinKarp(pattern);
    String txt = "Technically, this algorithm is only similar to the true number in a non-decimal";
    int index = rk.search(txt);
    System.out.println(txt);
    if (index == -1) {
      System.out.println("no match");
    } else {
      for (int i = 0; i < index; i++) {
        System.out.print(" ");
      }
      System.out.println(pattern);
      System.out.println("match index: " + index);
    }
  }

}
