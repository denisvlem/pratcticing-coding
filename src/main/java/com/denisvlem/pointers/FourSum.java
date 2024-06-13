package com.denisvlem.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);

    var resultSet = new HashSet<List<Integer>>();
    for (int first = 0; first < nums.length; ++first) {

      for (int second = first + 1; second < nums.length; ++second) {
        int third = second + 1;
        int fourth = nums.length - 1;
        while (third < fourth) {
          long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];
          if (sum == target) {
            resultSet.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
            third++;
            fourth--;
          } else if (sum < target) {
            third++;
          } else {
            fourth--;
          }
        }
      }
    }

    return new ArrayList<>(resultSet);
  }

}
