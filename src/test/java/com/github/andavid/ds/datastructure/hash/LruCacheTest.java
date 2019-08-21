package com.github.andavid.ds.datastructure.hash;

import org.junit.Test;

public class LruCacheTest {

  @Test
  public void testLruCache() {
    LruCache cache = new LruCache(4, 6);
    cache.put("1", "a");
    cache.put("4", "d");
    cache.put("2", "b");
    cache.put("3", "c");
    cache.put("5", "e");
    cache.put("8", "h");
    cache.put("6", "f");
    cache.put("7", "g");
    cache.printAll();

    cache.remove("5");
    cache.get("6");
    cache.put("2", "x");
    cache.put("9", "y");
    cache.printAll();
  }
}
