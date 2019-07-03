package com.github.andavid.ds.datastructure.tree;

import org.junit.Test;

public class ArrayBinaryTreeTest {

  @Test
  public void testArrayBinaryTree() {
    int capacity = 7;

    ArrayBinaryTree tree = new ArrayBinaryTree(capacity);
    for (int i = 1; i <= capacity; i++) {
      tree.insert(i);
    }

    tree.preOrder(1);
    tree.inOrder(1);
    tree.postOrder(1);
  }

}