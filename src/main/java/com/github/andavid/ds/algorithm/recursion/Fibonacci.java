package com.github.andavid.ds.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
  public int f1(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;
    return f1(n - 1) + f1(n - 2);
  }

  private Map<Integer, Integer> map = new HashMap<>();

  public int f2(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;

    if (map.containsKey(n)) {
      return map.get(n);
    }

    int result = f2(n - 1) + f2(n - 2);
    map.put(n, result);
    return result;
  }

  public int f3(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;

    int one_step_before = 1;
    int two_steps_before = 1;
    int result = 0;

    for (int i = 2; i < n; i++) {
      result = one_step_before + two_steps_before;
      two_steps_before = one_step_before;
      one_step_before = result;
    }

    return result;
  }
}
