package com.github.andavid.ds.datastructure.tree;

public class ArrayBinaryTree {

  /**
   * 完全二叉树，数组顺序存储。
   * 为了方便获取左右孩子节点以及父亲节点，从下标 1 开始存储数据。
   * 数组下标为 i 的节点，左孩子节点下标为 i * 2
   * 右孩子节点下标为 i * 2 + 1
   * 父亲节点下标为 i / 2
   */
  private int[] array;

  /** 二叉树存储的最大数据个数 */
  private int n;

  /** 二叉树已经存储的数据个数 */
  private int count;

  public ArrayBinaryTree(int capacity) {
    array = new int[capacity + 1];
    n = capacity;
    count = 0;
  }

  public void insert(int data) {
    if (count >= n) {
      return;
    }

    count++;
    array[count] = data;
  }

  public void preOrder(int index) {
    if (index > count) {
      return;
    }

    System.out.print(array[index]);
    if (index == count) {
      System.out.println();
    } else {
      System.out.print("->");
    }

    preOrder(index * 2);
    preOrder(index * 2 + 1);
  }

  public void inOrder(int index) {
    if (index > count) {
      return;
    }

    inOrder(index * 2);

    System.out.print(array[index]);
    if (index == count) {
      System.out.println();
    } else {
      System.out.print("->");
    }

    inOrder(index * 2 + 1);
  }

  public void postOrder(int index) {
    if (index > count) {
      return;
    }

    postOrder(index * 2);
    postOrder(index * 2 + 1);

    System.out.print(array[index]);
    if (index == 1) {
      System.out.println();
    } else {
      System.out.print("->");
    }
  }

}