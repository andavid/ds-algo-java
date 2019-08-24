package com.github.andavid.ds.datastructure.hash;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 带虚拟结点的一致性哈希算法
 */
public class ConsistentHash<T> {
  /**
   * 虚拟结点个数
   */
  private int virtualNodeNumber;

  private final static int DEFAULT_VIRTUAL_NODE_NUMBER = 32;

  /**
   * 存储虚拟结点的哈希值到真实结点的映射
   */
  private SortedMap<Integer, T> circle;

  /**
   * 真实结点列表
   */
  private List<T> realNodes;

  public ConsistentHash(Collection<T> nodes) {
    this(DEFAULT_VIRTUAL_NODE_NUMBER, nodes);
  }

  public ConsistentHash(int virtualNodeNumber, Collection<T> nodes) {
    this.virtualNodeNumber = virtualNodeNumber;

    circle = new TreeMap<>();
    realNodes = new LinkedList<>();

    for (T node : nodes) {
      add(node);
    }
  }

  public void add(T node) {
    realNodes.add(node);
    for (int i = 0; i < virtualNodeNumber; i++) {
      String virtualNode = node.toString() + "#" + i;
      circle.put(hash(virtualNode), node);
    }
  }

  public void remove(T node) {
    realNodes.remove(node);
    for (int i = 0; i < virtualNodeNumber; i++) {
      String virtualNode = node.toString() + "#" + i;
      circle.remove(hash(virtualNode));
    }
  }

  public T get(Object key) {
    if (circle.isEmpty()) {
      return null;
    }

    int hash = hash(key);
    if (!circle.containsKey(hash)) {
      // 在 int 范围内找到第一个大于该哈希值的 int 值，如果没有，则返回 TreeMap 的第一个 key 值。
      SortedMap<Integer, T> tailMap = circle.tailMap(hash);
      if (tailMap.isEmpty()) {
        hash = circle.firstKey();
      } else {
        hash = tailMap.firstKey();
      }
    }

    return circle.get(hash);
  }

  public void print() {
    int count = 0;
    for (T node : realNodes) {
      for (int i = 0; i < virtualNodeNumber; i++) {
        String virtualNode = node.toString() + "#" + i;
        System.out.println(++count + ": " + virtualNode + " --> " + hash(virtualNode));
      }
    }
  }

  public int hash(Object obj) {
    // String 的 hashCode 方法会产生负数，并且分布不均匀，因此需要找个算法重新计算 Hash 值
    // 这里使用 FNV1_32_HASH 算法计算 Hash 值
    String str = obj.toString();
    final int p = 16777619;
    int hash = (int) 2166136261L;
    for (int i = 0; i < str.length(); i++) hash = (hash ^ str.charAt(i)) * p;
    hash += hash << 13;
    hash ^= hash >> 7;
    hash += hash << 3;
    hash ^= hash >> 17;
    hash += hash << 5;

    // 如果算出来的值为负数则取其绝对值
    if (hash < 0) hash = Math.abs(hash);
    return hash;
  }

}
