package com.github.andavid.ds.algorithm.stringmatch;

/**
 * 字符串朴素匹配算法
 */
public class BruteForce {
  public int find(String txt, String pattern) {
    if (txt == null || pattern == null || txt.length() < pattern.length()) {
      return -1;
    }

    // 遍历主串
    for (int i = 0; i + pattern.length() <= txt.length(); i++) {
      // 遍历模式串
      if (match(txt, pattern, i)) {
        return i;
      }
    }

    return -1;
  }

  private boolean match(String txt, String pattern, int start) {
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) != txt.charAt(i + start)) {
        return false;
      }
    }
    return true;
  }

}
