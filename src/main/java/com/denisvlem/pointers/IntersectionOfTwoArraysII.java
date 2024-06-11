package com.denisvlem.pointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 350. Intersection of Two Arrays II
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/"/>
 */
public class IntersectionOfTwoArraysII {

  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    var left = 0;
    var right = 0;
    var n = nums1.length;
    var m = nums2.length;
    var resultList = new ArrayList<Integer>();

    while (left < n && right < m) {
      if (nums1[left] == nums2[right]) {
        resultList.add(nums1[left]);
        right++;
        left++;
      } else if (nums1[left] < nums2[right]) {
        left++;
      } else {
        right++;
      }
    }

    int[] result = new int[resultList.size()];

    for (int i = 0; i < resultList.size(); ++i) {
      result[i] = resultList.get(i);
    }

    return result;
  }

}
