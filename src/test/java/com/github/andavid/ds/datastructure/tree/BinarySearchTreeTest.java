package com.github.andavid.ds.datastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void testBinarySearchTree() {
    TreeNode root = new TreeNode(3);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(6);
    root.left = node2;
    root.right = node3;
    node3.left = node4;
    node3.right = node5;

    BinaryTree tree = new BinaryTree();
    System.out.println(tree.levelOrder(root));

    BinarySearchTree bst = new BinarySearchTree(root);
    System.out.println("insert 1");
    bst.insert(1);
    System.out.println(tree.levelOrder(root));

    TreeNode node = bst.find(5);
    if (node != null) {
      System.out.println("find node " + node.val);
    }

    System.out.println("delete 5");
    bst.delete(5);
    System.out.println(tree.levelOrder(root));

    System.out.println("max node " + bst.maximum().val);
    System.out.println("min node " + bst.minimum().val);

    int data = 4;
    System.out.println("Predecessor node of " + data + " is: ");
    if (bst.predecessor(data) != null) {
      System.out.println(bst.predecessor(data).val);
    } else {
      System.out.println("null");
    }

    System.out.println("Successor node of " + data + " is: ");
    if (bst.successor(data) != null) {
      System.out.println(bst.successor(data).val);
    } else {
      System.out.println("null");
    }
  }

  @Test
  public void testSerialize() {
    TreeNode root = new TreeNode(5);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(6);
    TreeNode node4 = new TreeNode(2);
    TreeNode node5 = new TreeNode(7);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node3.right = node5;

    BinarySearchTree bst = new BinarySearchTree(root);
    System.out.println(bst.serialize(root));

    String list = "5,3,2,6,7,";
    assertEquals(bst.serialize(bst.deserialize(list)), list);
  }

}