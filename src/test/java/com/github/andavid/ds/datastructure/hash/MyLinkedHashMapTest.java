package com.github.andavid.ds.datastructure.hash;

import org.junit.Test;

public class MyLinkedHashMapTest {

  @Test
  public void testMyLinkedHashMap() {
    MyLinkedHashMap m1 = new MyLinkedHashMap(4);
    m1.put("1", "a");
    m1.put("4", "d");
    m1.put("2", "b");
    m1.put("3", "c");
    m1.printAll();

    MyLinkedHashMap m2 = new MyLinkedHashMap(4, true);
    m2.put("3", "11");
    m2.put("1", "12");
    m2.put("5", "23");
    m2.put("2", "22");

    m2.put("3", "26");
    m2.get("5");
    m2.remove("1");
    m2.printAll();
  }
}
