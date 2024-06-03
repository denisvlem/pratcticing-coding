package com.denisvlem.arrays;

public class LongestOneSubsequent {

    public int solve(int[] array) {
        int current = 0;
        int best = 0;

        for (int i : array) {
            if(i > 0) {
                current += 1;
                best = Math.max(current, best);
            } else {
                current = 0;
            }
        }
        return best;
    }
}
