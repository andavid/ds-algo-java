package com.github.andavid.ds.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

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

  public TreeNode maximum() {
    return getMaxNode(root);
  }

  public TreeNode getMaxNode(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode p = node;
    while (p.right != null) {
      p = p.right;
    }
    return p;
  }

  public TreeNode minimum() {
    return getMinNode(root);
  }

  public TreeNode getMinNode(TreeNode node) {
    if (node == null) {
      return null;
    }
    TreeNode p = node;
    while (p.left != null) {
      p = p.left;
    }
    return p;
  }

  /**
   * 查找节点的前驱节点。
   * 中序遍历的前一个节点，小于该节点的所有节点中最大的那个节点。
   */
  public TreeNode predecessor(int data) {
    if (root == null) {
      return null;
    }

    TreeNode parent = null; // 查找过程中当前节点的父亲节点
    TreeNode lastR = null; // 最后一次在查找路径中出现右拐的节点
    TreeNode p = root;
    while (p != null) {
      if (p.val == data) {
        break; // 查找到节点
      }
      parent = p;
      if (data < p.val) {
        p = p.left;
      } else {
        lastR = p;
        p = p.right;
      }
    }

    if (p == null) {
      return null; // 没有找到节点
    }

    // 如果节点有左子树，那么该节点的前驱节点是其左子树中值最大的节点
    if (p.left != null) {
      return getMaxNode(p.left);
    }

    // 如果是最小的节点，则没有前驱节点
    if (parent == null || lastR == null) {
      return null;
    }

    // 如果节点没有左子树，那么判断该节点和其父节点的关系
    if (p == parent.right) {
      // 如果节点是其父亲节点的右边节点，那么该节点的前驱结点即为其父亲节点
      return parent;
    } else {
      // 如果节点是其父亲节点的左边孩子，那么沿着其父亲节点一直向树的顶端寻找出现右拐的节点
      return lastR;
    }
  }

  /**
   * 查找节点的后继节点。
   * 中序遍历的后一个节点，大于该节点的所有节点中最小的那个节点。
   */
  public TreeNode successor(int data) {
    if (root == null) {
      return null;
    }

    TreeNode parent = null; // 查找过程中当前节点的父亲节点
    TreeNode lastL = null; // 最后一次在查找路径中出现左拐的节点
    TreeNode p = root;
    while (p != null) {
      if (p.val == data) {
        break; // 查找到节点
      }
      parent = p;
      if (data < p.val) {
        lastL = p;
        p = p.left;
      } else {
        p = p.right;
      }
    }

    if (p == null) {
      return null; // 没有找到节点
    }

    // 如果节点有右子树，那么该节点的后继节点是其右子树中值最小的节点
    if (p.right != null) {
      return getMinNode(p.right);
    }

    // 如果是最大的节点，则没有后继节点
    if (parent == null || lastL == null) {
      return null;
    }

    // 如果节点没有右子树，那么判断该节点和其父节点的关系
    if (p == parent.left) {
      // 如果节点是其父亲节点的左边节点，那么该节点的后继结点即为其父亲节点
      return parent;
    } else {
      // 如果节点是其父亲节点的右边孩子，那么沿着其父亲节点一直向树的顶端寻找出现左拐的节点
      return lastL;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  public void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val + ",");
    buildString(root.left, sb);
    buildString(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("")) {
      return null;
    }
    String[] strs = data.split(",");
    Queue<Integer> queue = new LinkedList<>();
    for (String str : strs) {
      queue.offer(Integer.valueOf(str));
    }
    return buildTree(queue);
  }

  public TreeNode buildTree(Queue<Integer> queue) {
    if (queue.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(queue.poll());
    Queue<Integer> smallerQueue = new LinkedList<>();
    while (!queue.isEmpty() && queue.peek() < root.val) {
      smallerQueue.offer(queue.poll());
    }
    root.left = buildTree(smallerQueue);
    root.right = buildTree(queue);
    return root;
  }
}