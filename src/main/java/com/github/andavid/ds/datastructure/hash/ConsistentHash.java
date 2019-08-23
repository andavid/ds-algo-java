package com.github.andavid.ds.datastructure.hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

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
  private List<T> nodeList;

  public ConsistentHash(Collection<T> nodes) {
    this(DEFAULT_VIRTUAL_NODE_NUMBER, nodes);
  }

  public ConsistentHash(int virtualNodeNumber, Collection<T> nodes) {
    this.virtualNodeNumber = virtualNodeNumber;

    circle = new TreeMap<>();
    nodeList = new ArrayList<>();

    for (T node : nodes) {
      add(node);
    }
  }

  public void add(T node) {
    nodeList.add(node);
    for (int i = 0; i < virtualNodeNumber; i++) {
      String virtualNode = node.toString() + "#" + i;
      circle.put(hash(virtualNode), node);
    }
  }

  public void remove(T node) {
    nodeList.remove(node);
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
    for (T node : nodeList) {
      for (int i = 0; i < virtualNodeNumber; i++) {
        String virtualNode = node.toString() + "#" + i;
        System.out.println(++count + ": " + virtualNode + " --> " + hash(virtualNode));
      }
    }
  }

  public int hash(Object str) {
    return str.hashCode() & 0x7FFFFFFF;
  }

}
