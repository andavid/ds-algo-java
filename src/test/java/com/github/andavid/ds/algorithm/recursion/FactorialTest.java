package com.github.andavid.ds.algorithm.recursion;

import org.junit.Test;

public class FactorialTest {

  @Test
  public void testFactorial() {
    Factorial instance = new Factorial();

    int n = 9;

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
