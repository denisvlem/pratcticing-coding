package com.denisvlem.pointers;

public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int left = 0;
    int right = 0;

    var sorted = new int[n + m];
    int currentIndex = 0;
    while (left < m && right < n) {
      if (nums1[left] < nums2[right]) {
        sorted[currentIndex] = nums1[left];
        left++;
      } else {
        sorted[currentIndex] = nums2[right];
        right++;
      }
      currentIndex++;
    }

    while(left < m) {
      sorted[currentIndex] = nums1[left];
      left++;
      currentIndex++;
    }

    while(right < n) {
      sorted[currentIndex] = nums2[right];
      right++;
      currentIndex++;
    }

    if (n + m >= 0)
      System.arraycopy(sorted, 0, nums1, 0, n + m);
  }
}
