package com.github.andavid.ds.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
  public int f1(int n) {
    if (n <= 0) return 1;
    if (n == 1) return 1;
    return n * f1(n - 1);
  }

  private Map<Integer, Integer> map = new HashMap<>();
  public int f2(int n) {
    if (n <= 0) return 1;
    if (n == 1) return 1;

    if (map.containsKey(n)) {
      return map.get(n);
    }

    int result = n * f2(n - 1);
    map.put(n, result);
    return result;
  }

  public int f3(int n) {
    if (n <= 0) return 1;
    if (n == 1) return 1;

    int result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}
