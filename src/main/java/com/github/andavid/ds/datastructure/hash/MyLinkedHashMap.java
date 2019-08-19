package com.github.andavid.ds.datastructure.hash;

/**
 * 实现一个基于链表法解决冲突问题的散列表
 */
public class MyLinkedHashMap {

  private Node[] table;
  private int capacity;

  public MyLinkedHashMap() {
    this(16);
  }

  public MyLinkedHashMap(int capacity) {
    this.capacity = capacity;
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
    Node curr = table[index];

    if (curr == null) {
      // 槽位为空，直接添加链表头结点
      table[index] = new Node(key, value, null);
    } else {
      Node e = null;
      Node prev = null;
      // 遍历链表，查找是否存在 key
      while (curr != null) {
        if (key.equals(curr.key)) {
          e = curr;
          break;
        }
        prev = curr;
        curr = curr.next;
      }
      if (e != null) {
        // 存在 key，替换 value
        e.value = value;
      } else {
        // 找到链表最后一个结点
        prev.next = new Node(key, value, null);
      }
    }
  }

  int hash(Object key) {
    int h = key.hashCode();
    return (h ^ (h >>> 16)) % capacity;
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
