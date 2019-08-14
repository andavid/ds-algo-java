package com.github.andavid.ds.datastructure.stack;

public class SampleBrowser {
  private LinkedListStack backStack;
  private LinkedListStack forwardStack;
  private String currentUrl;

  public SampleBrowser() {
    backStack = new LinkedListStack();
    forwardStack = new LinkedListStack();
  }

  public void open(String url) {
    if (currentUrl != null) {
      backStack.push(currentUrl);
      forwardStack.clear();
    }
    loadUrl(url, "open");
  }

  public boolean canGoBack() {
    return !backStack.empty();
  }

  public void goBack() {
    if (canGoBack()) {
      forwardStack.push(currentUrl);
      String url = backStack.pop();
      loadUrl(url, "back");
    } else {
      System.out.println("can't go back.");
    }
  }

  public boolean canGoForward() {
    return !forwardStack.empty();
  }

  public void goForward() {
    if (canGoForward()) {
      backStack.push(currentUrl);
      String url = forwardStack.pop();
      loadUrl(url, "forward");
    } else {
      System.out.println("can't go forward");
    }
  }

  public void loadUrl(String url, String prefix) {
    currentUrl = url;
    System.out.println(prefix + " url: " + url);
  }

  public void checkCurrentPage() {
    System.out.println("current url: " + currentUrl);
  }

  public static class LinkedListStack {
    private Node head;
    private int count = 0;

    public LinkedListStack() {
      head = null;
      count = 0;
    }

    public void push(String data) {
      head = new Node(data, head);
      count++;
    }

    public String pop() {
      if (head == null) {
        throw new IllegalArgumentException("Stack empty");
      }

      String data = head.data;
      head = head.next;
      count--;
      return data;
    }

    public void clear() {
      head = null;
      count = 0;
    }

    public int size() {
      return count;
    }

    public boolean empty() {
      return size() == 0;
    }

  }

  public static class Node {
    private String data;
    private Node next;

    public Node(String data) {
      this(data, null);
    }

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

}
