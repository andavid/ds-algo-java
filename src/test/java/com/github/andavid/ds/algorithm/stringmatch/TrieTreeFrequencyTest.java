package com.github.andavid.ds.algorithm.stringmatch;

import java.util.Arrays;
import org.junit.Test;

public class TrieTreeFrequencyTest {

  @Test
  public void testTrieTreeFrequency() {
    TrieTreeFrequency trieTree = new TrieTreeFrequency();

    String txt = "he her hello home so see say just so so hello world";
    String[] words = txt.split(" ");
    System.out.println("total words: " + words.length);
    System.out.println(Arrays.toString(words));

    for (String word : words) {
      trieTree.insert(word);
    }
    System.out.println("trieTree: ");
    System.out.println(trieTree);

    System.out.println("so" + " : " + trieTree.frequency("so"));
    System.out.println("he" + " : " + trieTree.frequency("he"));
    System.out.println("hello" + " : " + trieTree.frequency("hello"));
    System.out.println("hel" + " : " + trieTree.frequency("hel"));
  }

}
