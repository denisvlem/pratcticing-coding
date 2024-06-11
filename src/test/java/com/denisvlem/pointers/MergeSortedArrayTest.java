package com.denisvlem.pointers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MergeSortedArrayTest {

  @Test
  void merge() {

    var n = 3;
    var m = 4;

    int[] nums1 = new int[]{1,2,3,0,0,0,0};
    int[] nums2 = new int[]{1,2,3,4};

    new MergeSortedArray().merge(nums1, n, nums2, m);

    assertThat(nums1).isEqualTo(new int[]{1,1,2,2,3,3,4});
  }
}