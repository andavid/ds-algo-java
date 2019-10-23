package com.github.andavid.ds.algorithm.stringmatch;

public class TrieTree {
  private TrieNode root = new TrieNode('/');

  public void insert(String txt) {
    if (txt == null) return;
    TrieNode p = root;
    char[] txtArray = txt.toCharArray();
    for (int i = 0; i < txtArray.length; i++) {
      int index = txtArray[i] - 'a';
      if (p.children[index] == null) {
        p.children[index] = new TrieNode(txtArray[i]);
      }
      p = p.children[index];
    }
    p.isEndingChar = true;
  }

  public boolean find(String pattern) {
    if (pattern == null) return false;
    TrieNode p = root;
    char[] patternArray = pattern.toCharArray();
    for (int i = 0; i < patternArray.length; i++) {
      int index = patternArray[i] - 'a';
      if (p.children[index] == null) {
        return false;
      }
      p = p.children[index];
    }
    return p.isEndingChar;
  }

  public class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) {
      this.data = data;
    }
  }
}
