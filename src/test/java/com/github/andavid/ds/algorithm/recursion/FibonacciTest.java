package com.github.andavid.ds.algorithm.recursion;

import org.junit.Test;

public class FibonacciTest {

  @Test
  public void testFibonacci() {
    Fibonacci instance = new Fibonacci();

    int n = 30;

    long time = System.currentTimeMillis();
    System.out.println(instance.f1(n));
    System.out.println("f1: " + (System.currentTimeMillis() - time) + "ms");

    time = System.currentTimeMillis();
    System.out.println(instance.f2(n));
    System.out.println("f2: " + (System.currentTimeMillis() - time) + "ms");

    time = System.currentTimeMillis();
    System.out.println(instance.f3(n));
    System.out.println("f3: " + (System.currentTimeMillis() - time) + "ms");
  }
}
