package com.github.andavid.ds.datastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryTreeTest {

  @Test
  public void testBinaryTree() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;

    BinaryTree tree = new BinaryTree();

    // 前序遍历
    System.out.println("preorder:");
    tree.preorder(root);
    System.out.println();

    System.out.println("preorderTraversal1:");
    System.out.println(tree.preorderTraversal1(root).toString());

    System.out.println("preorderTraversal2:");
    System.out.println(tree.preorderTraversal2(root).toString());

    // 中序遍历
    System.out.println("inorder:");
    tree.inorder(root);
    System.out.println();

    System.out.println("inorderTraversal1:");
    System.out.println(tree.inorderTraversal(root).toString());

    // 后序遍历
    System.out.println("postorder:");
    tree.postorder(root);
    System.out.println();

    System.out.println("postorderTraversal1:");
    System.out.println(tree.postorderTraversal1(root).toString());

    System.out.println("postorderTraversal2:");
    System.out.println(tree.postorderTraversal2(root).toString());

    // 按层遍历
    System.out.println("level order:");
    System.out.println(tree.levelOrder(root));

    // 树的高度
    System.out.println("max depth = " + tree.maxDepth(root));

    // 平衡二叉树
    System.out.println("isBalanced = " + tree.isBalanced(root));
  }

  @Test
  public void testSymmetric() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(3);
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;

    BinaryTree tree = new BinaryTree();
    System.out.println("isSymmetric = " + tree.isSymmetric(root));
  }

  @Test
  public void testSerialize() {
    TreeNode root = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    root.left = node2;
    root.right = node3;
    node3.left = node4;
    node3.right = node5;

    BinaryTree tree = new BinaryTree();
    System.out.println(tree.serialize(root));
    System.out.println(tree.serialize(null));
  }

  @Test
  public void testDeserialize() {
    BinaryTree tree = new BinaryTree();

    String list = "[1,2,3,null,null,4,5]";
    assertEquals(tree.serialize(tree.deserialize(list)), list);

    list = "[5,4,7,3,null,2,null,-1,null,9]";
    assertEquals(tree.serialize(tree.deserialize(list)), list);

    list = "[1,null,2,3]";
    assertEquals(tree.serialize(tree.deserialize(list)), list);
  }
}