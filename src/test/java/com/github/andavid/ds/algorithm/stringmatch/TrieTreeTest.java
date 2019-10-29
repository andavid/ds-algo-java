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
    trie.insert("so");
    trie.insert("here");
    System.out.println(trie);

    System.out.println(trie.contains("how"));
    System.out.println(trie.contains("hero"));

    System.out.println(trie.search("h"));
    System.out.println(trie.search("he"));
  }
}
