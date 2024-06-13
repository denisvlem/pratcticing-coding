package com.denisvlem.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> resultSet = new HashSet<>();

    for (int first = 0; first < nums.length; ++first) {

      var second = first + 1;
      var third = nums.length - 1;

      while (second < third) {
        var sum = nums[first] + nums[second] + nums[third];
        if (sum == 0) {
          resultSet.add(Arrays.asList(nums[first], nums[second], nums[third]));
          second++;
          third--;
        } else if (sum < 0) {
          second++;
        } else {
          third--;
        }
      }
    }

    return new ArrayList<>(resultSet);
  }
}
