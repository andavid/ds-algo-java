package com.github.andavid.ds.datastructure.hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapUsage {
  public static void main(String[] args) {
    HashMap<String, String> m1 = new LinkedHashMap<>();
    m1.put("1", "a");
    m1.put("4", "d");
    m1.put("2", "b");
    m1.put("3", "c");
    System.out.println(m1);

    for (Map.Entry entry : m1.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }

    // 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序
    HashMap<Integer, Integer> m2 = new LinkedHashMap<>(10, 0.75f, true);
    m2.put(3, 11);
    m2.put(1, 12);
    m2.put(5, 23);
    m2.put(2, 22);

    m2.put(3, 26);
    m2.get(5);

    System.out.println(m2);

    for (Map.Entry entry : m2.entrySet()) {
      System.out.println(entry.getKey() + "=" + entry.getValue());
    }

  }
}
