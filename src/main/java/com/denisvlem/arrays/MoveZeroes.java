package com.denisvlem.arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * <p>
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        var nextZeroIndex = nums.length - 1;

        while(nums[nextZeroIndex] == 0 && nextZeroIndex > 0) {
            nextZeroIndex--;
        }

        if(nextZeroIndex == 0) {
            return;
        }

        for (int i = nextZeroIndex - 1; i >= 0; --i) {
            if (nums[i] == 0) {
                for (int j = i; j < nextZeroIndex; ++j) {
                    nums[j] = nums[j + 1];
                }
                nums[nextZeroIndex] = 0;
                nextZeroIndex--;
            }
        }
    }
}
