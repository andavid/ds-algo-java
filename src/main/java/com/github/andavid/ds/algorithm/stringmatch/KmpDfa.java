package com.github.andavid.ds.algorithm.stringmatch;

public class KmpDfa {
  private int R;
  private int[][] dfa;
  private String pattern;

  public KmpDfa(String pattern) {
    this(pattern, 256);
  }

  public KmpDfa(String pattern, int R) {
    this.R = R;
    this.pattern = pattern;
    buildDfa();
  }

  private void buildDfa() {
    // dfa[c][j] 表示状态 j 遇到字符 c 转移到哪个状态
    dfa = new int[R][pattern.length()];
    // base case，起始状态 0 遇到模式串的第一个字符，将转移到状态 1
    dfa[pattern.charAt(0)][0] = 1;
    // 重启状态初始为 0
    int x = 0;
    // 当前状态从 1 开始
    for (int j = 1; j < pattern.length(); j++) {
      for (int c = 0; c < R; c++) {
        dfa[c][j] = dfa[c][x];
      }
      // 状态 j 遇到模式串索引 j 的字符，将转移到状态 j+1
      dfa[pattern.charAt(j)][j] = j + 1;
      // 更新重启状态
      x = dfa[pattern.charAt(j)][x];
    }
  }

  public int search(String txt) {
    int i = 0;
    int j = 0;

    while (i < txt.length() && j < pattern.length()) {
      j = dfa[txt.charAt(i)][j];
      i++;
    }

    if (j == pattern.length()) {
      return i - j;
    }
    return -1;
  }
}
