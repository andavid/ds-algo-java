package com.github.andavid.ds.algorithm.stringmatch;

import org.junit.Test;

public class KmpDfaTest {

  @Test
  public void testKmpDfa() {
    test("abacadabrabracabracadabrabrabracad", "abracadabra");
    test("abacadabrabracabracadabrabrabracad", "rab");
    test("abacadabrabracabracadabrabrabracad", "bcara");
  }

  private void test(String txt, String pattern) {
    KmpDfa kmp = new KmpDfa(pattern);
    int offset = kmp.search(txt);

    System.out.println("text:    " + txt);

    System.out.print("pattern: ");
    for (int i = 0; i < offset; i++) {
      System.out.print(" ");
    }
    System.out.println(pattern);

    if (offset != -1) {
      System.out.println("match position: " + offset);
    } else {
      System.out.println("no match");
    }

    System.out.println();
  }

}
