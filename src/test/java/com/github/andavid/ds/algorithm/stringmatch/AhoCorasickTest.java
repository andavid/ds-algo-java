package com.github.andavid.ds.algorithm.stringmatch;

import org.junit.Test;

public class AhoCorasickTest {

  @Test
  public void test() {
    String[] patterns = {"at", "art", "oars", "soar"};
    AhoCorasick ac = new AhoCorasick(patterns);
    System.out.println(ac.match("soarsoars"));


    String[] patterns2 = {"Fxtec Pro1", "谷歌 Pixel"};
    ac = new AhoCorasick(patterns2);
    String txt = "一家总部位于伦敦的公司 Fxtex 在 MWC 上就推出了一款名为 Fxtec Pro1 的手机，该机最大的亮点就是采用了侧滑式全键盘设计。DxOMark 年度总榜发布 华为 P20 Pro / 谷歌 Pixel 3 争冠";
    System.out.println(ac.match(txt));
  }

}
