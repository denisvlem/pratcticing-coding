package com.denisvlem.tree.binary;

/**
 * @see <a
 * href=https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/"/>
 */
public class SortedArrayToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    return makeATree(0, nums.length - 1, nums);
  }

  private TreeNode makeATree(int left, int right, int[] nums) {
    if (right == left + 1) {
      return new TreeNode(nums[right], new TreeNode(nums[left], null, null), null);
    } else if (right == left) {
      return new TreeNode(nums[right], null, null);
    } else {
      int middle = (right + left) / 2;
      return new TreeNode(
          nums[middle],
          makeATree(left, middle - 1, nums),
          makeATree(middle + 1, right, nums)
      );
    }
  }
}
