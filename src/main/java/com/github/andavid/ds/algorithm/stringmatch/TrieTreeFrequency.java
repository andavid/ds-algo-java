package com.github.andavid.ds.algorithm.stringmatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrieTreeFrequency {

  public class TrieNode {
    public char data;
    public int frequency;
    public boolean isEndingChar = false;
    Map<Character, TrieNode> children = new HashMap<>();
    public TrieNode(char data) {
      this.data = data;
    }
  }

  private TrieNode root = new TrieNode('/');

  public void insert(String word) {
    TrieNode p = root;

    for (Character ch : word.toCharArray()) {
      if (!p.children.containsKey(ch)) {
        p.children.put(ch, new TrieNode(ch));
      }
      p = p.children.get(ch);
      p.frequency++;
    }

    p.isEndingChar = true;
  }

  public int frequency(TrieNode p) {
    if (p.children.size() == 0) {
      return p.frequency;
    } else {
      int childrenFrequency = 0;
      for (TrieNode child : p.children.values()) {
        childrenFrequency += frequency(child);
      }
      return p.frequency - childrenFrequency;
    }
  }

  public int frequency(String word) {
    TrieNode p = root;
    for (Character ch : word.toCharArray()) {
      if (!p.children.containsKey(ch)) {
        return 0;
      }
      p = p.children.get(ch);
    }

    if (p.isEndingChar) {
      return frequency(p);
    }

    return 0;
  }

  private void traverse(List<String> list, TrieNode trieNode, String prefix) {
    if (trieNode == null) {
      return;
    }

    if (trieNode.isEndingChar) {
      list.add(prefix);
    }

    for (TrieNode child : trieNode.children.values()) {
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
