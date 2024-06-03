package com.denisvlem.arrays;

public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        int lastIndex = -1;

        for(int i = 0; i < s.length(); ++i) {
            int currentIndex = t.indexOf(s.charAt(i));
            if (currentIndex <= lastIndex) {
                return false;
            }
            lastIndex = currentIndex;
        }
        return true;
    }
}
