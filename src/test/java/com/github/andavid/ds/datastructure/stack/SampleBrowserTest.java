package com.github.andavid.ds.datastructure.stack;

import org.junit.Test;

public class SampleBrowserTest {

  @Test
  public void testSampleBrowser() {
    SampleBrowser browser = new SampleBrowser();
    browser.open("http://www.baidu.com");
    browser.open("http://news.baidu.com");
    browser.open("http://news.baidu.com/ent");
    browser.goBack();
    browser.goBack();
    browser.goForward();
    browser.open("http://www.qq.com");
    browser.goForward();
    browser.goBack();
    browser.goForward();
    browser.goBack();
    browser.goBack();
    browser.goBack();
    browser.goBack();
    browser.checkCurrentPage();
  }
}
