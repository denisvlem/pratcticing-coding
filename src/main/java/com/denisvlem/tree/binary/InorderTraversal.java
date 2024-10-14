package com.denisvlem.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a
 * href=https://leetcode.com/problems/binary-tree-inorder-traversal/?envType=problem-list-v2&envId=binary-tree"/>
 */
public class InorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {
    var stack = new LinkedList<TreeNode>();
    var resultList = new ArrayList<Integer>();

    var currentNode = root;
    while (currentNode != null || !stack.isEmpty()) {
      while (currentNode != null) {
        stack.push(currentNode);
        currentNode = currentNode.left;
      }
      currentNode = stack.pop();
      resultList.add(currentNode.val);
      currentNode = currentNode.right;
    }

    return resultList;
  }
}
