package com.denisvlem.pointers;

public class SortColors {

  public void sortColors(int[] nums) {
    var center = 0;
    var left = 0;
    var right = nums.length - 1;

    while (center <= right) {
      if (nums[center] == 0) {
        var tmp = nums[left];
        nums[left] = nums[center];
        nums[center] = tmp;
        left++;
        center++;
      } else if (nums[center] == 1) {
        center++;
      } else {
        var tmp = nums[right];
        nums[right] = nums[center];
        nums[center] = tmp;
        right--;
      }
    }
  }
}
