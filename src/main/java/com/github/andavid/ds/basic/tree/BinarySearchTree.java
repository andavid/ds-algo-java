package com.github.andavid.ds.basic.tree;

public class BinarySearchTree {
  private TreeNode root;

  public BinarySearchTree(TreeNode node) {
    root = node;
  }

  public TreeNode find(int data) {
    TreeNode p = root;
    while (p != null) {
      if (data < p.val) {
        p = p.left;
      } else if (data > p.val) {
        p = p.right;
      } else {
        return p;
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
      if (data < p.val) {
        if (p.left == null) {
          p.left = new TreeNode(data);
          return;
        }
        p = p.left;
      } else {
        if (p.right == null) {
          p.right = new TreeNode(data);
          return;
        }
        p = p.right;
      }
    }
  }

  public void delete(int data) {
    TreeNode p = root;
    TreeNode parent = null;

    while (p != null && p.val != data) {
      parent = p;
      if (data < p.val) {
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
      // 要删除的节点变成了右子树的最小节点
      // 由于该节点肯定不会有左孩子，因此可以使用接下来的代码进行删除
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

  public TreeNode getMaxNode() {
    if (root == null) {
      return null;
    }
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    return p;
  }

  public TreeNode getMinNode() {
    if (root == null) {
      return null;
    }
    TreeNode p = root;
    while (p.left != null) {
      p = p.left;
    }
    return p;
  }

}