package com.denisvlem.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PMExpression {

  public static void main(String[] args) throws IOException {

    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      var expression = reader.readLine();
      System.out.println(calculate(expression));
    }
  }

  //100+2*30+393*300+45+47
  public static int calculate(String expression) {

    var result = 0;
    var currentMultiplyBlock = 1;
    var currentDigit = 0;

    for (char ch : expression.toCharArray()) {
      if (ch == '*' || ch == '+') {
        if (ch == '+') {
          currentMultiplyBlock *= currentDigit;
          result += currentMultiplyBlock;
          currentMultiplyBlock = 1;
        } else {
          currentMultiplyBlock *= currentDigit;
        }
        currentDigit = 0;
      } else {
        currentDigit = currentDigit * 10 + (ch - '0');
      }
    }

    currentMultiplyBlock *= currentDigit;
    result += currentMultiplyBlock;

    return result;
  }

}
