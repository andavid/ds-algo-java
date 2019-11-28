package com.github.andavid.ds.algorithm.stringmatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * AC 自动机
 */
public class AhoCorasick {

  public class AcNode {
    private String data;
    private Map<String, AcNode> children;
    private boolean isEndingChar;
    private int length;
    private AcNode fail;

    public AcNode(String data) {
      this.data = data;
      this.children = new HashMap<>();
      this.isEndingChar = false;
      this.length = 0;
      this.fail = null;
    }
  }

  private AcNode root;

  public AhoCorasick() {
    this.root = new AcNode("/");
  }

  public AhoCorasick(String[] patterns) {
    this();

    for (String pattern : patterns) {
      insert(pattern);
    }

    buildFailurePointer();
  }

  /**
   * 往 AC 自动机插入一个模式字符串
   */
  public void insert(String pattern) {
    AcNode p = root;

    for (int i = 0; i < pattern.length(); i++) {
      String c = pattern.charAt(i) + "";
      if (!p.children.containsKey(c)) {
        p.children.put(c, new AcNode(c));
      }
      p = p.children.get(c);
    }

    p.isEndingChar = true;
    p.length = pattern.length();
  }

  /**
   * 构建失败指针
   */
  private void buildFailurePointer() {
    Queue<AcNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      AcNode p = queue.poll();

      for (AcNode pChild : p.children.values()) {
        if (pChild == null) {
          continue;
        }

        if (p == root) {
          pChild.fail = root;
        } else {
          // 节点 p 的失败指针指向节点 q
          AcNode q = p.fail;
          while (q != null) {
            AcNode qChild = q.children.get(pChild.data);
            if (qChild != null) {
              // 如果找到节点 q 的一个子节点 qChild，跟节点 p 的子节点 pChild 字符相同，
              // 则将节点 pChild 的失败指针指向节点 qChild
              pChild.fail = qChild;
              break;
            }
            // 如果节点 q 中没有子节点的字符等于节点 pChild 包含的字符，继续查找下一个失败指针
            q = q.fail;
          }

          if (q == null) {
            pChild.fail = root;
          }
        }

        queue.offer(pChild);
      }
    }
  }

  public boolean match(String txt) {
    AcNode p = root;

    for (int i = 0; i < txt.length(); i++) {
      String c = txt.charAt(i) + "";

      // 如果 p 指向的所有节点都没能匹配当前字符，则跳到 p 的失败指针
      while (p != root && p.children.get(c) == null) {
        p = p.fail;
      }
      p = p.children.get(c);

      if (p == null) {
        // 如果没有匹配的，从 root 重新开始匹配
        p = root;
      }

      AcNode temp = p;
      // 检查是否有失败指针为结尾字符
      while (temp != root) {
        if (temp.isEndingChar) {
          System.out.println("匹配起始下标: " + (i - temp.length + 1) + "; 长度: " + temp.length);
          return true;
        }
        temp = temp.fail;
      }
    }

    return false;
  }

}
