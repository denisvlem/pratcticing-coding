package com.denisvlem.strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and
 * return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            if(charCountMap.get(currentChar) == 1) {
                return i;
            }
        }
        return -1;
    }
}
