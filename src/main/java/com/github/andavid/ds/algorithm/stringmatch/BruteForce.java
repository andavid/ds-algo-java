package com.github.andavid.ds.algorithm.stringmatch;

/**
 * 字符串朴素匹配算法
 */
public class BruteForce {

  public int match(String txt, String pattern) {
    if (txt == null || pattern == null || txt.length() < pattern.length()) {
      return -1;
    }

    int i = 0;
    int j = 0;
    while (i < txt.length() && j < pattern.length()) {
      if (txt.charAt(i) == pattern.charAt(j)) {
        // 当前字符匹配成功，主串和模式串都往后移动一位
        i++;
        j++;
      } else {
        // 当前字符匹配失败，主串回溯到匹配开始位置(i-j)的后面一位(i-j+1)，模式串从头开始匹配
        i = i - j + 1;
        j = 0;
      }
    }

    if (j == pattern.length()) {
      return i - j;
    }
    return -1;
  }

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
