package com.denisvlem.dynamic;

/**
 * Given a string s, return the longest
 * palindromic
 * <p>
 * substring
 * in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    public String longestPalindromicSubstring(String s) {

        if (null == s || s.length() < 2) {
            return s;
        }

        int[] longest = new int[]{0, 1};
        for (int i = 0; i < s.length() - 1; ++i) {
            var resultOdd = longestPalindrome(i - 1, i + 1, s);
            longest = getLength(longest) > getLength(resultOdd) ? longest : resultOdd;

            var resultEven = longestPalindrome(i, i + 1, s);
            longest = getLength(longest) > getLength(resultEven) ? longest : resultEven;
        }
        return s.substring(longest[0], longest[1]);
    }

    private int getLength(int[] indices) {
        return indices[1] - indices[0];
    }

    private int[] longestPalindrome(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int []{left + 1, right};
    }
}
