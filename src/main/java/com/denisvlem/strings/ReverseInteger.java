package com.denisvlem.strings;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean isPositive = x >= 0;
        int abs = isPositive ? x : -x;

        var absStringReversed = new StringBuilder(String.valueOf(abs)).reverse();
        if (!isPositive) {
            absStringReversed = new StringBuilder("-").append(absStringReversed);
        }

        try {
            return Integer.parseInt(absStringReversed.toString());
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
