package com.github.andavid.ds.algorithm.stringmatch;

public class Kmp {
  private String pattern;
  private int[] next;

  public Kmp(String pattern) {
    this.pattern = pattern;
    generateNext();
  }

  private void generateNext() {
    int len = pattern.length();
    next = new int[len];
    next[0] = -1;

    int k = -1;
    int j = 0;
    while (j < len - 1) {
      // next[j] = k 表示索引 j 之前的字符串有最大长度为 k 的相同前缀和后缀
      if (k == -1 || (pattern.charAt(k) == pattern.charAt(j))) {
        // 如果 p[k] = p[j]，next[j+1] = next[j] + 1 = k + 1
        k++;
        j++;
        next[j] = k;
      } else {
        // 继续查找次长的相同前缀和后缀
        k = next[k];
      }
    }
  }

  public int match(String src) {
    if (src == null || pattern == null || src.length() < pattern.length()) {
      return -1;
    }

    int i = 0;
    int j = 0;
    while (i < src.length() && j < pattern.length()) {
      if (j == -1 || src.charAt(i) == pattern.charAt(j)) {
        // 当前字符匹配成功，主串和模式串都往后移动一位
        // 或者 j == -1 时，主串后移一位，模式串从头(j = 0)开始匹配
        i++;
        j++;
      } else {
        // 当前字符匹配失败，主串位置不变，模式串相对于主串向右移动 j - next[j] 位
        j = next[j];
      }
    }

    if (j == pattern.length()) {
      return i - j;
    }
    return -1;
  }

}
