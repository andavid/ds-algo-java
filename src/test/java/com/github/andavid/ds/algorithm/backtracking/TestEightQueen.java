package com.github.andavid.ds.algorithm.backtracking;

import org.junit.Test;

public class TestEightQueen {

  @Test
  public void testEightQueen() {
    EightQueen instance = new EightQueen();
    instance.cal8queens(0);
  }
}