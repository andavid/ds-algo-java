package com.github.andavid.ds.datastructure.hash;

public class LruCache extends MyLinkedHashMap {
  private static final int MAX_CACHE_SIZE = 100;
  private int limit;

  public LruCache() {
    this(16, MAX_CACHE_SIZE);
  }

  public LruCache(int initialCapacity, int limit) {
    super(initialCapacity, true);
    this.limit = limit;
  }

  protected boolean removeEldestEntry(Entry eldest) {
    return size() > limit;
  }
}
