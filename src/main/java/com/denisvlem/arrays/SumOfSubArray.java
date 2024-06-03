package com.denisvlem.arrays;

public class SumOfSubArray {

    public boolean sumOfSubArray(int[] array, int target) {

        if(array.length == 0) return false;

        int right = 0;
        int currentSum = 0;
        for (int left = 0; left < array.length; ++left) {
            if(left > 0) {
                currentSum -= array[left - 1];
            }

            while (currentSum < target && right < array.length) {
                currentSum += array[right++];
            }

            if (currentSum == target) {
                return true;
            }
        }
        return false;
    }
}
