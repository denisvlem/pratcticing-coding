package com.denisvlem.strings;

import java.util.HashMap;

public class RomanToInt {

  public int romanToInt(String s) {
    int lastReadNumber = 0;
    var rules = new HashMap<Character, Integer>();
    rules.put('I', 1);
    rules.put('V', 5);
    rules.put('X', 10);
    rules.put('L', 50);
    rules.put('C', 100);
    rules.put('D', 500);
    rules.put('M', 1000);

    int result = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      var currentChar = s.charAt(i);
      var currentIntVal = rules.get(currentChar);

      if (currentIntVal < lastReadNumber) {
        result -= currentIntVal;
      } else {
        result += currentIntVal;
      }
      lastReadNumber = currentIntVal;
    }
    return result;
  }
}
