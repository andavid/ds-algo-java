package com.github.andavid.ds.datastructure.hash;

import java.util.Arrays;

/**
 * 实现一个基于链表法解决冲突问题的散列表。
 * 实现较为简单，key 不能为空，不支持动态扩容。
 */
public class MyHashMap {

  private Node[] table;
  private int size;

  private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 16

  public MyHashMap() {
    this(DEFAULT_INITIAL_CAPACITY);
  }

  public MyHashMap(int capacity) {
    table = new Node[capacity];
  }

  public String get(String key) {
    Node p = getNode(key);
    return (p == null) ? null : p.value;
  }

  private Node getNode(String key) {
    int index = hash(key);
    Node p = table[index];

    // 遍历整个链表
    while (p != null) {
      if (key.equals(p.key)) {
        break;
      }
      p = p.next;
    }

    return p;
  }

  public void put(String key, String value) {
    int index = hash(key);
    Node p = table[index];

    if (p == null) {
      // 槽位为空，直接添加链表头结点
      table[index] = new Node(key, value, null);
      size++;
    } else {
      Node target = null;
      Node prev = null;

      // 遍历链表，查找是否存在 key
      while (p != null) {
        if (key.equals(p.key)) {
          target = p;
          break;
        }
        prev = p;
        p = p.next;
      }

      if (target != null) {
        // 存在 key，替换 value
        target.value = value;
      } else {
        // 不存在 key，在链表末尾添加一个结点
        prev.next = new Node(key, value, null);
        size++;
      }
    }
  }

  public String remove(String key) {
    Node node = removeNode(key);
    return (node == null) ? null : node.value;
  }

  private Node removeNode(String key) {
    int index = hash(key);
    Node p = table[index];

    if (p != null) {
      Node first = p;
      Node target = null;
      Node prev = null;

      while (p != null) {
        if (key.equals(p.key)) {
          target = p;
          break;
        }
        prev = p;
        p = p.next;
      }

      if (target != null) {
        if (target == first) {
          // 删除的是链表第一个结点
          table[index] = target.next;
        } else {
          prev.next = target.next;
        }
        size--;
        // 返回删除的结点
        return target;
      }
    }

    return null;
  }

  public void printAll() {
    System.out.println("size = " + size());
    System.out.println(toString());
    for (int i = 0; i < table.length; i++) {
      System.out.print("slot " + i + ": ");
      for (Node p = table[i]; p != null; p = p.next) {
        System.out.print("(" + p.key + "=" + p.value + ")");
        if (p.next != null) {
          System.out.print(" --> ");
        }
      }
      System.out.println();
    }
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for (int i = 0; i < table.length; i++) {
      for (Node p = table[i]; p != null; p = p.next) {
        sb.append(p.key);
        sb.append("=");
        sb.append(p.value);
        sb.append(",").append(" ");
      }
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append("}");
    return sb.toString();
  }

  public boolean containsKey(String key) {
    return getNode(key) != null;
  }

  public boolean containsValue(String value) {
    for (int i = 0; i < table.length; i++) {
      for (Node p = table[i]; p != null; p = p.next) {
        if (value.equals(p.value)) {
          return true;
        }
      }
    }
    return false;
  }

  public void clear() {
    size = 0;
    Arrays.fill(table, null);
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private int hash(Object key) {
    int h = key.hashCode();
    return (h ^ (h >>> 16)) % table.length;
  }

  class Node {
    String key;
    String value;
    Node next;

    public Node(String key, String value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public String getKey() {
      return key;
    }

    public String getValue() {
      return value;
    }

    public String toString() {
      return key + "=" + value;
    }
  }

}
