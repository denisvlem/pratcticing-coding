package com.denisvlem.tree.binary;

public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public TreeNode(int val) {
    this(val, null, null);
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }

}
