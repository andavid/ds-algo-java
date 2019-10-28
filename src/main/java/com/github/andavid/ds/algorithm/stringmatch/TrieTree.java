package com.github.andavid.ds.algorithm.stringmatch;

import java.util.ArrayList;
import java.util.List;

public class TrieTree {

  public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) {
      this.data = data;
    }
  }

  private TrieNode root = new TrieNode('/');

  /**
   * 将关键词插入到 Trie 树
   */
  public void insert(String word) {
    TrieNode p = root;

    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (p.children[index] == null) {
        p.children[index] = new TrieNode(ch);
      }
      p = p.children[index];
    }

    p.isEndingChar = true;
  }

  /**
   * 在 Trie 树中查询一个关键词
   */
  public boolean contains(String word) {
    TrieNode p = root;

    for (char ch : word.toCharArray()) {
      int index = ch - 'a';
      if (p.children[index] == null) {
        return false;
      }
      p = p.children[index];
    }

    return p.isEndingChar;
  }

  /**
   * 在 Trie 树中查询所有 prefix 前缀的关键词
   */
  public List<String> search(String prefix) {
    List<String> list = new ArrayList<>();
    TrieNode p = root;

    for (char ch : prefix.toCharArray()) {
      int index = ch - 'a';
      if (p.children[index] == null) {
        return list;
      }
      p = p.children[index];
    }

    traverse(list, p, prefix);

    return list;
  }

  private void traverse(List<String> list, TrieNode trieNode, String prefix) {
    if (trieNode == null) {
      return;
    }

    if (trieNode.isEndingChar) {
      list.add(prefix);
      return;
    }

    for (TrieNode child : trieNode.children) {
      if (child != null) {
        traverse(list, child, prefix + child.data);
      }
    }
  }

  @Override
  public String toString() {
    List<String> list = new ArrayList<>();
    traverse(list, root, "");
    return list.toString();
  }

}
