package com.denisvlem.arrays;

import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays,
 * and you may return the result in any order.
 *
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
 * load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        sortArrays(nums1, nums2);

        final int maxLength = Math.max(nums1.length, nums2.length);
        int[] tmp = new int[maxLength];

        int intersectionCount = 0;
        int nextSearchIndex = 0;
        for (int j : nums1) {
            for (int k = nextSearchIndex; k < nums2.length; ++k) {
                if (nums2[k] == j) {
                    tmp[intersectionCount++] = nums2[k];
                    nextSearchIndex = k + 1;
                    break;
                }
            }
        }
        return Arrays.copyOf(tmp, intersectionCount);
    }

    private void sortArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
