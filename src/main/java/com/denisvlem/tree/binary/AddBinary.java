package com.denisvlem.tree.binary;

import java.math.BigInteger;

public class AddBinary {

  public String addBinary(String a, String b) {
    var left = new BigInteger(a, 2);
    var right = new BigInteger(b, 2);
    return left.add(right).toString(2);
  }
}
