package com.denisvlem.strings;

/**
 * 58. Length of Last Word
 *
 * @see <a href="https://leetcode.com/problems/length-of-last-word/"/>
 */
public class LengthOfTheLastWord {

  public int lengthOfLastWord(String s) {
    var words = s.split(" +");
    return words[words.length - 1].length();
  }
}
