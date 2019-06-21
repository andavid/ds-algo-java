package com.github.andavid.ds.basic.tree;

public class BinarySearchTree {
  private TreeNode root;

  public BinarySearchTree(TreeNode node) {
    root = node;
  }

  public TreeNode find(int data) {
    TreeNode p = root;
    while (p != null) {
      if (data == p.val) {
        return p;
      } else if (data < p.val) {
        p = p.left;
      } else {
        p = p.right;
      }
    }
    return null;
  }

  public void insert(int data) {
    if (root == null) {
      root = new TreeNode(data);
      return;
    }

    TreeNode p = root;
    while (p != null) {
      if (data > p.val) {
        if (p.right == null) {
          p.right = new TreeNode(data);
          return;
        }
        p = p.right;
      } else {
        if (p.left == null) {
          p.left = new TreeNode(data);
          return;
        }
        p = p.left;
      }
    }
  }

  public void delete(int data) {
    TreeNode p = root;
    TreeNode parent = null;

    while (p != null && p.val != data) {
      parent = p;
      if (p.val > data) {
        p = p.left;
      } else {
        p = p.right;
      }
    }

    if (p == null) {
      return; // 没有找到要删除的节点
    }

    // 要删除的节点有两个孩子节点
    if (p.left != null && p.right != null) {
      TreeNode minNode = p.right;
      TreeNode minNodeParent = p;
      // 找到右子树的最小节点，替换到要删除的节点上
      while (minNode.left != null) {
        minNodeParent = minNode;
        minNode = minNode.left;
      }
      p.val = minNode.val;
      // 删除右子树的最小节点（肯定不会有左子树）
      p = minNode;
      parent = minNodeParent;
    }

    // 删除叶子节点，或者只有一个孩子的节点
    TreeNode child;
    if (p.left != null) {
      child = p.left;
    } else if (p.right != null) {
      child = p.right;
    } else {
      child = null;
    }

    if (parent == null) {
      // 删除的是根节点
      root = child;
    } else if (parent.left == p) {
      parent.left = child;
    } else {
      parent.right = child;
    }
  }

}