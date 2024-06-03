package com.denisvlem.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * <p>
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        var sLength = s.length();
        var tLength = t.length();

        if (sLength != tLength) {
            return false;
        }

        char[] count = new char[26];

        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        for (char ct : t.toCharArray()) {
            if (count[ct - 'a'] == 0) {
                return false;
            }
            count[ct - 'a']--;
        }

        return true;
    }
}
