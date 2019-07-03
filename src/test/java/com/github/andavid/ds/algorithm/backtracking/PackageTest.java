package com.github.andavid.ds.algorithm.backtracking;

import org.junit.Test;

public class PackageTest {

  @Test
  public void testPackage() {
    int[] items = new int[] {10, 20, 30, 40, 35, 45, 55, 75};
    Package pkg = new Package();
    pkg.calMaxWeight(0, 0, items, 8, 102);
    System.out.println("最大值: " + pkg.maxWeight);
  }
}