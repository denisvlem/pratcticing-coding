package com.denisvlem.tree.binary;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a
 * href="https://leetcode.com/problems/binary-tree-postorder-traversal/description/?envType=problem-list-v2&envId=binary-tree"/>
 */
public class PostorderTraversal {

  /**
   * The key to solution is it's like the {@link PreorderTraversal} but in the opposite order
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    var result = new LinkedList<Integer>();
    var stack = new LinkedList<TreeNode>();
    var currentNode = root;

    while (!stack.isEmpty() || currentNode != null) {
      if (currentNode != null) {
        stack.push(currentNode);
        result.push(currentNode.val);
        currentNode = currentNode.right;
      } else {
        currentNode = stack.pop();
        currentNode = currentNode.left;
      }
    }
    return result;
  }
}
