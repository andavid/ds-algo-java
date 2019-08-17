package com.github.andavid.ds.datastructure.skiplist;

import com.github.andavid.ds.datastructure.skiplist.SkipList.Node;
import org.junit.Test;

public class SkipListTest {

  @Test
  public void testSkipList() {
    SkipList skipList = new SkipList();
    skipList.insert(1);
    skipList.insert(3);
    skipList.insert(5);
    skipList.insert(7);
    skipList.insert(9);
    skipList.insert(12);
    System.out.println(skipList);

    Node node = skipList.find(5);
    if (node != null) {
      System.out.println(node);
    } else {
      System.out.println("not found");
    }

    skipList.delete(5);
    System.out.println(skipList);

    node = skipList.find(5);
    if (node != null) {
      System.out.println(node);
    } else {
      System.out.println("not found");
    }

  }
}
