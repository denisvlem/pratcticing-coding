package com.denisvlem.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a
 * href="https://leetcode.com/problems/binary-tree-preorder-traversal/description/?envType=problem-list-v2&envId=binary-tree"/>
 */
public class PreorderTraversal {

  public List<Integer> preorderTraversal(TreeNode root) {
    var currentNode = root;
    var stack = new LinkedList<TreeNode>();
    var resultList = new ArrayList<Integer>();

    while (!stack.isEmpty() || currentNode != null) {
      if (currentNode != null) {
        resultList.add(currentNode.val);
        stack.push(currentNode);
        currentNode = currentNode.left;
      } else {
        currentNode = stack.pop();
        currentNode = currentNode.right;
      }
    }

    return resultList;
  }
}
