package com.denisvlem.pointers;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/"/>
 */
public class TwoSumII {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;

    while(left < right) {
      var sum = numbers[left] + numbers[right];
      if (sum < target) {
        left++;
      } else if(sum > target) {
        right--;
      } else {
        return new int[] {left + 1, right + 1};
      }
    }

    return new int[]{-1, -1};
  }

}
