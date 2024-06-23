package com.denisvlem.strings;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 12. Integer to Roman
 *
 * @see <a href="https://leetcode.com/problems/integer-to-roman/>
 */
public class IntToRoman {

  public String intToRoman(int n) {
    var map = new TreeMap<Integer, String>(Comparator.reverseOrder());
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");

    var result = new StringBuilder();

    for (var entry : map.entrySet()) {
      while (n >= entry.getKey()) {
        n -= entry.getKey();
        result.append(entry.getValue());
      }
    }

    return result.toString();
  }
}
