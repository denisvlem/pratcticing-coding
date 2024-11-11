package com.denisvlem.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @see <a
 * href="https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=problem-list-v2&envId=binary-tree"/>
 */
public class LevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode treeNode) {
    List<List<Integer>> result = new ArrayList<>();
    if (treeNode == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(treeNode);
    while (!queue.isEmpty()) {
      int nodesOnTheLevel = queue.size();
      var levelNodes = new ArrayList<Integer>();
      for (int i = 0; i < nodesOnTheLevel; ++i) {
        var nextLevelElement = queue.peek();
        assert nextLevelElement != null;
        if (nextLevelElement.left != null) {
          queue.add(nextLevelElement.left);
        }
        if (nextLevelElement.right != null) {
          queue.add(nextLevelElement.right);
        }
        levelNodes.add(queue.remove().val);
      }
      result.add(levelNodes);
    }

    return result;
  }
}
