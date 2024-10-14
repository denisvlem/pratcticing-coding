package com.denisvlem.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a
 * href="https://leetcode.com/problems/binary-tree-postorder-traversal/description/?envType=problem-list-v2&envId=binary-tree"/>
 */
public class PostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    var result = new LinkedList<Integer>();
    Deque<TreeNode> stack = new LinkedList<>();

    var currentNode = root;

    while (!stack.isEmpty() || currentNode != null) {
      if (currentNode != null) {
        stack.push(currentNode);
        result.addFirst(currentNode.val);
        currentNode = currentNode.right;
      } else {
        TreeNode node = stack.pop();
        currentNode = node.left;
      }
    }
    return result;
  }
}
