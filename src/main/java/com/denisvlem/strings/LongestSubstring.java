package com.denisvlem.strings;

import java.util.*;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var longest = 0;
        Set<Character> distinct = new HashSet<>();

        for (int right = 0; right < s.length(); ++right) {
            if (!distinct.contains(s.charAt(right))) {
                distinct.add(s.charAt(right));
                longest = Math.max(longest, right - left + 1);
            } else {
                while(distinct.contains(right)) {
                    distinct.remove(s.charAt(left));
                    left++;
                }
                distinct.add(s.charAt(right));
            }
        }
        return longest;
    }
}
