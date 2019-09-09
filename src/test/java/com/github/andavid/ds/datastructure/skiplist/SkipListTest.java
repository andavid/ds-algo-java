package com.github.andavid.ds.datastructure.skiplist;

import com.github.andavid.ds.datastructure.skiplist.SkipList.Node;
import org.junit.Test;

public class SkipListTest {

  @Test
  public void testSkipList() {
    SkipList skipList = new SkipList();
    for (int i = 1; i <= 32; i++) {
      skipList.insert(i);
    }
    System.out.println(skipList);

    Node node = skipList.find(11);
    if (node != null) {
      System.out.println(node);
    } else {
      System.out.println("not found");
    }

    skipList.delete(11);
    System.out.println(skipList);

    node = skipList.find(11);
    if (node != null) {
      System.out.println(node);
    } else {
      System.out.println("not found");
    }

  }
}
