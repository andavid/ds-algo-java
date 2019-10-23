package com.github.andavid.ds.algorithm.stringmatch;

import org.junit.Test;

public class TrieTreeTest {

  @Test
  public void testTrieTree() {
    TrieTree trie = new TrieTree();
    trie.insert("hello");
    trie.insert("her");
    trie.insert("hi");
    trie.insert("how");
    trie.insert("so");
    trie.insert("see");

    System.out.println(trie.find("how"));
    System.out.println(trie.find("here"));
  }
}
