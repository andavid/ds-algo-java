package com.github.andavid.ds.datastructure.hash;

public class MyLinkedHashMap extends MyHashMap {

  /**
   * 双向链表头结点，最早插入或访问的结点
   */
  Entry head;

  /**
   * 双向链表尾结点，最新插入或最近访问的结点
   */
  Entry tail;

  /**
   * true 表示访问顺序，false 表示插入顺序，默认为 false
   */
  boolean accessOrder;

  public MyLinkedHashMap() {
    super();
    accessOrder = false;
  }

  public MyLinkedHashMap(int initialCapacity) {
    super(initialCapacity);
    accessOrder = false;
  }

  public MyLinkedHashMap(int initialCapacity, boolean accessOrder) {
    super(initialCapacity);
    this.accessOrder = accessOrder;
  }

  // 将结点插入到双向链表末尾
  private void linkNodeLast(Entry p) {
    Entry last = tail;
    tail = p;
    if (last == null) {
      head = p;
    } else {
      p.before = last;
      last.after = p;
    }
  }

  // 创建新结点，并插入到双向链表的末尾
  Node newNode(String key, String value, Node next) {
    Entry p = new Entry(key, value, next);
    linkNodeLast(p);
    return p;
  }

  // 从双向链表中删除结点
  void afterNodeRemoval(Node e) {
    Entry p = (Entry)e;
    Entry b = p.before;
    Entry a = p.after;
    p.before = p.after = null;

    if (b == null) {
      head = a;
    } else {
      b.after = a;
    }

    if (a == null) {
      tail = b;
    } else {
      a.before = b;
    }
  }

  // 删除最早插入或访问的结点
  void afterNodeInsertion() {
    Entry first = head;
    if (first != null && removeEldestEntry(first)) {
      String key = first.key;
      removeNode(key);
    }
  }

  public String get(String key) {
    Node e = getNode(key);
    if (e == null) {
      return null;
    }
    if (accessOrder) {
      afterNodeAccess(e);
    }
    return e.value;
  }

  // 如果是访问顺序，将结点移动到双向链表的末尾
  void afterNodeAccess(Node e) {
    Entry last = tail;
    if (accessOrder && last != e) {
      Entry p = (Entry)e;
      Entry b = p.before;
      Entry a = p.after;
      p.after = null;

      if (b == null) {
        head = a;
      } else {
        b.after = a;
      }

      if (a == null) {
        last = b;
      } else {
        a.before = b;
      }

      if (last == null) {
        head = p;
      } else {
        p.before = last;
        last.after = p;
      }

      tail = p;
    }
  }

  public boolean containsValue(String value) {
    for (Entry e = head; e != null; e = e.after) {
      if (value.equals(e.value)) {
        return true;
      }
    }
    return false;
  }

  public void clear() {
    super.clear();
    head = tail = null;
  }

  protected boolean removeEldestEntry(Entry eldest) {
    return false;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for (Entry p = head; p != null; p = p.after) {
      sb.append(p.key);
      sb.append("=");
      sb.append(p.value);
      sb.append(",").append(" ");
    }
    sb.delete(sb.length() - 2, sb.length());
    sb.append("}");
    return sb.toString();
  }

  class Entry extends MyHashMap.Node {
    Entry before, after;
    Entry(String key, String value, Node next) {
      super(key, value, next);
    }
  }
}
