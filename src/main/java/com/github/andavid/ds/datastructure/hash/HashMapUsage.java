package com.github.andavid.ds.datastructure.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUsage {
  public static void main(String[] args) {
    HashMap<String, String> m = new HashMap<>();
    m.put("1", "a");
    m.put("4", "d");
    m.put("2", "b");
    m.put("3", "c");
    System.out.println("打印 map: " + m);

    System.out.println("删除 key = 4");
    m.remove("4");
    System.out.println("打印 map: " + m);

    System.out.println("contains key 4: " + m.containsKey("4"));
    System.out.println("contains value b: " + m.containsValue("b"));

    Iterator iterator = m.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      System.out.println("next: " + entry.getKey() + "->" + entry.getValue());
    }

    System.out.println("add null key and value");
    m.put(null, "z");
    m.put("4", null);
    System.out.println("打印 map: " + m);
  }
}
