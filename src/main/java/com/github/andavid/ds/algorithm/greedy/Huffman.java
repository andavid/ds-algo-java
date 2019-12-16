package com.github.andavid.ds.algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

  private static final int R = 256;

  private Node root;

  private class Node implements Comparable<Node> {
    private char ch;
    private int freq;
    private Node left;
    private Node right;

    Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public boolean isLeaf() {
      return (left == null) && (right == null);
    }

    public int compareTo(Node that) {
      return this.freq - that.freq;
    }
  }

  public String encode(String src) {
    char[] input = src.toCharArray();

    // 统计每个字符出现的次数
    int[] freq = new int[R];
    for (int i = 0; i < input.length; i++) {
      freq[input[i]]++;
    }

    // 根据每个字符出现的次数构建哈夫曼树
    root = buildTrie(freq);

    // 根据哈夫曼树构建哈夫曼编码表
    String[] st = new String[R];
    buildCode(st, root, "");

    // 打印哈夫曼编码表
    printCode(st);

    // 使用哈夫曼编码表对字符串进行编码
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      sb.append(st[input[i]]);
    }

    return sb.toString();
  }

  public String decode(String code) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < code.length(); ) {
      Node x = root;

      while (!x.isLeaf()) {
        if (code.charAt(i) == '0') {
          x = x.left;
        } else {
          x = x.right;
        }
        i++;
      }

      sb.append(x.ch);
    }

    return sb.toString();
  }

  private Node buildTrie(int[] freq) {
    Queue<Node> pq = new PriorityQueue<Node>();

    for (char i = 0; i < R; i++) {
      if (freq[i] > 0) {
        pq.offer(new Node(i, freq[i], null, null));
      }
    }

    if (pq.size() == 1) {
      if (freq['\0'] == 0) {
        pq.offer(new Node('\0', 0, null, null));
      } else {
        pq.offer(new Node('\1', 0, null, null));
      }
    }

    while (pq.size() > 1) {
      Node left = pq.poll();
      Node right = pq.poll();
      Node parent = new Node('\0', left.freq + right.freq, left, right);
      pq.offer(parent);
    }

    return pq.poll();
  }

  private void buildCode(String[] st, Node x, String s) {
    if (!x.isLeaf()) {
      buildCode(st, x.left, s + "0");
      buildCode(st, x.right, s + "1");
    } else {
      st[x.ch] = s;
    }
  }

  private void printCode(String[] st) {
    for (char i = 0; i < R; i++) {
      if (st[i] != null && st[i].length() > 0) {
        System.out.println(i + " --> " + st[i]);
      }
    }
  }

}
