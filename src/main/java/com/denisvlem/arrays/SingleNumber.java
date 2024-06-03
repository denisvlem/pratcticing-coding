package com.denisvlem.arrays;

import java.util.Arrays;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (var num : nums) {
            result ^= num;
        }
        return result;
    }
}
