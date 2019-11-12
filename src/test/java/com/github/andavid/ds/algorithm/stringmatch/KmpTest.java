package com.github.andavid.ds.algorithm.stringmatch;

import org.junit.Test;

public class KmpTest {

  @Test
  public void testKmp() {
    String pattern = "search";
    Kmp kmp = new Kmp(pattern);
    String src = "substring searching algorithm";
    System.out.println(src);
    int index = kmp.match(src);
    for (int i = 0; i < index; i++) {
      System.out.print(" ");
    }
    System.out.println(pattern);
    System.out.println(index);
  }

}
