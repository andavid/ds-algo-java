package com.github.andavid.ds.datastructure.hash;

import org.junit.Test;

public class MyHashMapTest {

  @Test
  public void testMyHashMap() {
    MyHashMap m = new MyHashMap(4);
    m.put("1", "a");
    m.put("4", "d");
    m.put("2", "b");
    m.put("3", "c");
    m.put("5", "e");
    m.put("8", "h");
    m.put("6", "f");
    m.put("7", "g");
    m.put("9", "i");
    m.printAll();

    System.out.println();
    System.out.println("删除 key = 2, value = " + m.remove("2"));
    m.printAll();

    System.out.println();
    System.out.println("put(5, x)");
    m.put("5", "x");
    m.printAll();

    System.out.println();
    System.out.println("contains key 9: " + m.containsKey("9"));
    System.out.println("contains key 2: " + m.containsKey("2"));
    System.out.println("contains value x: " + m.containsValue("x"));
    System.out.println("contains value z: " + m.containsValue("z"));
  }
}
