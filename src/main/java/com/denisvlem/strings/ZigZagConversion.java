package com.denisvlem.strings;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 6. ZigZag Conversion.
 * <a href="https://leetcode.com/problems/zigzag-conversion/description/"/>
 */
public class ZigZagConversion {

  public String convert(String s, int numRows) {

    if (numRows >= s.length() || numRows == 1) {
      return s;
    }
    List<List<Character>> array = new ArrayList<>();
    for (int i = 0; i < numRows; ++i) {
      array.add(new ArrayList<>());
    }

    int row = 0;
    int stepDirection = 1;
    for (char ch : s.toCharArray()) {
      array.get(row).add(ch);
      if (row == 0) { //go forward
        stepDirection = 1;
      } else if (row == numRows - 1) { //go backward
        stepDirection = -1;
      }
      row += stepDirection;
    }

    var builder = new StringBuilder();
    for (var list : array) {
      builder.append(
          list.stream()
              .map(Object::toString)
              .collect(Collectors.joining(""))
      );
    }
    return builder.toString();
  }
}
