package com.github.andavid.ds.algorithm.greedy;

import org.junit.Test;

public class HuffmanTest {

  @Test
  public void testHuffman() {
    Huffman instance = new Huffman();

    String huffmanCode = instance.encode("ABRACADABRA!");
    System.out.println(huffmanCode);
    System.out.println(instance.decode(huffmanCode));

    huffmanCode = instance.encode("it was the best of times it was the worst of times.");
    System.out.println(huffmanCode);
    System.out.println(instance.decode(huffmanCode));

    huffmanCode = instance.encode("beep boop beer!");
    System.out.println(huffmanCode);
    System.out.println(instance.decode(huffmanCode));
  }
}